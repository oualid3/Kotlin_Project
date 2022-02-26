// Generated by view binder compiler. Do not edit!
package fr.epsi.kotlin_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import fr.epsi.kotlin_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTab1Binding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView firstNameTextView;

  @NonNull
  public final ImageView imageBarcode;

  @NonNull
  public final TextView lastNameTextView;

  @NonNull
  public final TextView textBarcodeNumber;

  private FragmentTab1Binding(@NonNull FrameLayout rootView, @NonNull TextView firstNameTextView,
      @NonNull ImageView imageBarcode, @NonNull TextView lastNameTextView,
      @NonNull TextView textBarcodeNumber) {
    this.rootView = rootView;
    this.firstNameTextView = firstNameTextView;
    this.imageBarcode = imageBarcode;
    this.lastNameTextView = lastNameTextView;
    this.textBarcodeNumber = textBarcodeNumber;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTab1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTab1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_tab1, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTab1Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.first_name_text_view;
      TextView firstNameTextView = ViewBindings.findChildViewById(rootView, id);
      if (firstNameTextView == null) {
        break missingId;
      }

      id = R.id.image_barcode;
      ImageView imageBarcode = ViewBindings.findChildViewById(rootView, id);
      if (imageBarcode == null) {
        break missingId;
      }

      id = R.id.last_name_text_view;
      TextView lastNameTextView = ViewBindings.findChildViewById(rootView, id);
      if (lastNameTextView == null) {
        break missingId;
      }

      id = R.id.text_barcode_number;
      TextView textBarcodeNumber = ViewBindings.findChildViewById(rootView, id);
      if (textBarcodeNumber == null) {
        break missingId;
      }

      return new FragmentTab1Binding((FrameLayout) rootView, firstNameTextView, imageBarcode,
          lastNameTextView, textBarcodeNumber);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}