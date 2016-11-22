package com.bit2016.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inflate
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_call).setOnClickListener(this);
        findViewById(R.id.button_address).setOnClickListener(this);
        findViewById(R.id.button_web).setOnClickListener(this);
        findViewById(R.id.button_search).setOnClickListener(this);
        findViewById(R.id.button_map).setOnClickListener(this);
        findViewById(R.id.button_share).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.button_call: {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1234-5678"));
                // 마시멜로우 버전부터는 보안이 강화되어서 추가로 코드를 써야하므로...
                // 일단은 버전은 롤리팝으로 낮춤...
                startActivity(intent);
                break;
            }
            case R.id.button_address: {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(Uri.parse("content://com.android.contacts/data/phones"));
                startActivity(intent);
                break;
            }
            case R.id.button_web: {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
                break;
            }
            case R.id.button_search: {
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.android.browser");
                intent.putExtra("query", "니코니코니");
                startActivity(intent);
                break;
            }
            case R.id.button_map: {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:38.899533,-77.036476") );
                startActivity(intent);
                break;
            }
            case R.id.button_share: {
                Intent intent = new Intent("com.bit2016.android.action.ACTION_SHARE");
                startActivity(intent);
                break;
            }
            default: {
                Toast.makeText(this, "Unknown View", Toast.LENGTH_LONG).show();
            }
        }
    }
}
