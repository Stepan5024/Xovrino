package com.stepan.bokarev.pro_cao;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private static final int ZXING_CAMERA_PERMISSION = 1;
    private Class<?> mClss;
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView =  new ZXingScannerView(this); //  Programmatically initialize the scanner view
        setContentView(mScannerView); //  Set the scanner view as the content view
    }
    public void launchActivity(Class<?> clss) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            mClss = clss;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, ZXING_CAMERA_PERMISSION);
        } else {
            Intent intent = new Intent(this, clss);
            startActivity(intent);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,  String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ZXING_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(mClss != null) {
                        Intent intent = new Intent(this, mClss);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(this, "Please grant camera permission to use the QR Scanner", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); //  Register ourselves as a handler for scan results.
        mScannerView.startCamera(); //  Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera(); //  Stop camera on pause
    }

    @Override
    public void handleResult( Result rawResult) {
        //  Do something with the result here
        Log.v("k", rawResult.getText()); //  Prints scan results
        Log.v("ll", rawResult.getBarcodeFormat().toString()); //  Prints the scan format (qrcode, pdf417 etc.)

        //  If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }
}