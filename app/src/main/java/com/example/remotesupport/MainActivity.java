
package com.example.remotesupport;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 48, 32, 32);
        layout.setBackgroundColor(Color.rgb(245, 247, 251));

        TextView title = new TextView(this);
        title.setText("Remote Support");
        title.setTextSize(26);
        title.setTextColor(Color.rgb(25, 35, 55));
        layout.addView(title);

        status = new TextView(this);
        status.setText("Status: belum ada sesi aktif");
        status.setTextSize(16);
        status.setPadding(0, 32, 0, 24);
        layout.addView(status);

        Button start = new Button(this);
        start.setText("Minta persetujuan sesi");
        layout.addView(start);

        start.setOnClickListener(v ->
            new AlertDialog.Builder(this)
                .setTitle("Persetujuan")
                .setMessage("Ini hanya demo lokal. Belum ada koneksi jarak jauh atau berbagi layar.")
                .setNegativeButton("Batal", (d, w) -> {})
                .setPositiveButton("Setuju", (d, w) -> {
                    status.setText("Status: demo disetujui, tanpa koneksi remote");
                    Toast.makeText(this, "Demo aktif", Toast.LENGTH_SHORT).show();
                })
                .show()
        );

        Button end = new Button(this);
        end.setText("Akhiri sesi demo");
        layout.addView(end);
        end.setOnClickListener(v ->
            status.setText("Status: belum ada sesi aktif")
        );

        setContentView(layout);
    }
}
