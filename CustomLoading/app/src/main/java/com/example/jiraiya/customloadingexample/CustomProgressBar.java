package com.example.jiraiya.customloadingexample;

import android.app.Activity;
import android.app.Dialog;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomProgressBar {

    public Dialog dialog;
    private Thread animate;


    public void create(Activity activity, String msg) {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_progressbar);

        final ImageView iv=(ImageView)dialog.findViewById(R.id.imageview);
        Drawable d=iv.getDrawable();
        if(d instanceof AnimatedVectorDrawableCompat){
            final AnimatedVectorDrawableCompat avdc=(AnimatedVectorDrawableCompat)d;
            //avdc.start();
            new Thread(new Runnable() {
                public void run() {
                    while (iv != null) {
                        try {
                            iv.post(new Runnable() {
                                @Override
                                public void run() {
                                    avdc.start();
                                }
                            });
                            Thread.sleep(500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
        else if(d instanceof AnimatedVectorDrawable)
        {
            final AnimatedVectorDrawable avd=(AnimatedVectorDrawable)d;
            //avd.start();

            new Thread(new Runnable() {
                public void run() {
                    while (iv != null) {
                        try {
                            iv.post(new Runnable() {
                                @Override
                                public void run() {
                                    avd.start();
                                }
                            });
                            Thread.sleep(500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }



        TextView text = (TextView) dialog.findViewById(R.id.yourmessage);
        text.setText(msg);
        dialog.show();
    }

    private void animate(){
        animate =new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        animate.start();
    }

    public void dismiss(){

        dialog.dismiss();
    }


}
