package com.example.myapplication;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class YesNoDialogFragment extends DialogFragment {

    MyGlobals myGlobals;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle(getTag()+"でよろしいですか") //タイトル表示文字

                //肯定的なボタン（はい）が押された場合
                .setPositiveButton("はい", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ((SelectNumberActivity) getActivity()).DialogYes();
                            }
                        }
                )

                //否定的なボタン（いいえ）が押された場合
                .setNegativeButton("いいえ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }
                )
                .create();  //これによりDialogを生成。
    }
}