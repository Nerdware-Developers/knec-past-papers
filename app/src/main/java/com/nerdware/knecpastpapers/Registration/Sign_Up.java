package com.nerdware.knecpastpapers.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nerdware.knecpastpapers.HelperClass;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import android.text.method.PasswordTransformationMethod;


public class Sign_Up extends AppCompatActivity {
    EditText signupName, signupUsername, signupEmail, signupPassword;
    RelativeLayout loginRedirectText;
    RelativeLayout signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    private boolean isUsernameAvailable;
    private boolean isEmailAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupName = findViewById(R.id.name);
        signupEmail = findViewById(R.id.email);
        signupUsername = findViewById(R.id.username);
        signupPassword = findViewById(R.id.password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.sign_btn2);

        // Set input type for password field
        signupPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        // This Line ensures the password characters are not visible
        signupPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword() | !validateEmail()) {
                    // Handle validation errors, if any.
                } else {
                    // Check if the username already exists
                    checkUsernameAvailability();

                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_Up.this, LogIn.class);
                startActivity(intent);
                finish();

            }
        });
    }


    private void checkUsernameAvailability() {
        final String username = signupUsername.getText().toString();

        reference.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot usernameSnapshot) {
                if (usernameSnapshot.exists()) {
                    // Username already exists, show an error message
                    signupUsername.setError("Username already exists. Choose another one.");
                    isUsernameAvailable = false;
                } else {
                    // Username is available, proceed to check email availability
                    isUsernameAvailable = true;
                    checkEmailAvailability();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle any database error if necessary
            }
        });
    }

    private void checkEmailAvailability() {
        final String email = signupEmail.getText().toString().trim();

        reference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot emailSnapshot) {
                if (emailSnapshot.exists()) {
                    // Email already exists, show an error message
                    signupEmail.setError("Email already registered. Choose another one.");
                    isEmailAvailable = false;
                } else {
                    // Email is available, proceed with registration
                    isEmailAvailable = true;
                    performUserRegistration();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle any database error if necessary
            }
        });
    }
    private void performUserRegistration() {
        if (isUsernameAvailable && isEmailAvailable) {
            String name = signupName.getText().toString();
            String email = signupEmail.getText().toString();
            String username = signupUsername.getText().toString();
            String password = signupPassword.getText().toString();

            HelperClass helperClass = new HelperClass(name, email, username, password);
            reference.child(username).setValue(helperClass);

            // Show success message
            Toast.makeText(Sign_Up.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();

            // Redirect to the main activity
            Intent intent = new Intent(Sign_Up.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();
        }
    }

    private boolean validateEmail() {
        String email = signupEmail.getText().toString().trim();

        if (email.isEmpty()) {
            signupEmail.setError("Email cannot be empty");
            return false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signupEmail.setError("Invalid email address");
            return false;
        } else {
            signupEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = signupPassword.getText().toString();
        if (val.isEmpty()) {
            signupPassword.setError("Password cannot be empty");
            return false;
        } else {
            signupPassword.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String val = signupUsername.getText().toString();
        if (val.isEmpty()) {
            signupUsername.setError("Username cannot be empty");
            return false;
        } else {
            signupUsername.setError(null);
            return true;
        }
    }
}
