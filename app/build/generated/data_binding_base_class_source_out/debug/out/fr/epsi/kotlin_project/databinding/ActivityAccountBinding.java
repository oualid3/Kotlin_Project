// Generated by view binder compiler. Do not edit!
package fr.epsi.kotlin_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import fr.epsi.kotlin_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAccountBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonOk;

  @NonNull
  public final EditText editEmailAccount;

  @NonNull
  public final EditText editTextAddressAccount;

  @NonNull
  public final EditText editTextCityAccount;

  @NonNull
  public final EditText editTextFirstNameAccount;

  @NonNull
  public final EditText editTextLastNameAccount;

  @NonNull
  public final EditText editTextZipcodeAccount;

  private ActivityAccountBinding(@NonNull LinearLayout rootView, @NonNull Button buttonOk,
      @NonNull EditText editEmailAccount, @NonNull EditText editTextAddressAccount,
      @NonNull EditText editTextCityAccount, @NonNull EditText editTextFirstNameAccount,
      @NonNull EditText editTextLastNameAccount, @NonNull EditText editTextZipcodeAccount) {
    this.rootView = rootView;
    this.buttonOk = buttonOk;
    this.editEmailAccount = editEmailAccount;
    this.editTextAddressAccount = editTextAddressAccount;
    this.editTextCityAccount = editTextCityAccount;
    this.editTextFirstNameAccount = editTextFirstNameAccount;
    this.editTextLastNameAccount = editTextLastNameAccount;
    this.editTextZipcodeAccount = editTextZipcodeAccount;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_account, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAccountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonOk;
      Button buttonOk = ViewBindings.findChildViewById(rootView, id);
      if (buttonOk == null) {
        break missingId;
      }

      id = R.id.editEmailAccount;
      EditText editEmailAccount = ViewBindings.findChildViewById(rootView, id);
      if (editEmailAccount == null) {
        break missingId;
      }

      id = R.id.editTextAddressAccount;
      EditText editTextAddressAccount = ViewBindings.findChildViewById(rootView, id);
      if (editTextAddressAccount == null) {
        break missingId;
      }

      id = R.id.editTextCityAccount;
      EditText editTextCityAccount = ViewBindings.findChildViewById(rootView, id);
      if (editTextCityAccount == null) {
        break missingId;
      }

      id = R.id.editTextFirstNameAccount;
      EditText editTextFirstNameAccount = ViewBindings.findChildViewById(rootView, id);
      if (editTextFirstNameAccount == null) {
        break missingId;
      }

      id = R.id.editTextLastNameAccount;
      EditText editTextLastNameAccount = ViewBindings.findChildViewById(rootView, id);
      if (editTextLastNameAccount == null) {
        break missingId;
      }

      id = R.id.editTextZipcodeAccount;
      EditText editTextZipcodeAccount = ViewBindings.findChildViewById(rootView, id);
      if (editTextZipcodeAccount == null) {
        break missingId;
      }

      return new ActivityAccountBinding((LinearLayout) rootView, buttonOk, editEmailAccount,
          editTextAddressAccount, editTextCityAccount, editTextFirstNameAccount,
          editTextLastNameAccount, editTextZipcodeAccount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
