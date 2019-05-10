package uk.co.niceagency.testexercice.view;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.niceagency.testexercice.R;

public class MainActivitys extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ((TextView) findViewById(R.id.hello_world_text)).setText(getString(R.string.hello_world_modified));
//
//        PackageInfo pInfo = null;
//        try {
//            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
//            ((TextView) findViewById(R.id.content)).setText(((TextView) findViewById(R.id.content)).getText().toString().concat(pInfo.versionName));
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        findViewById(R.id.cancel_action).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String message = getString(R.string.cancel_message);
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setMessage(message);
//                dialog.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, getString(R.string.toast_dummy), Toast.LENGTH_SHORT).show();
//                    }
//                }).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, getString(R.string.toast_dummy), Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                });
//                dialog.create().show();
//            }
//        });
//
//        findViewById(R.id.save_action).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String message = getString(R.string.save_message);
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setMessage(message);
//                dialog.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, getString(R.string.toast_dummy), Toast.LENGTH_SHORT).show();
//                    }
//                }).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, getString(R.string.toast_dummy), Toast.LENGTH_SHORT).show();
//
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
//                            if(!((EditText) findViewById(R.id.content)).getText().toString().isEmpty()){
//                                new Handler().postDelayed(new Runnable() {
//                                                              @Override
//                                                              public void run() {
//                                                                  String content = ((EditText) findViewById(R.id.content)).getText().toString();
//                                                                  String state = Environment.getExternalStorageState();
//                                                                  if (Environment.MEDIA_MOUNTED.equals(state)) {
//                                                                      FileOutputStream outputStream;
//                                                                      try {
//                                                                          File file = null;
//                                                                          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
//                                                                              file = new File(getExternalFilesDir(null), "test.txt");
//                                                                          }
//                                                                          outputStream = new FileOutputStream (file.getAbsolutePath().toString());
//                                                                          outputStream.write(content.getBytes());
//                                                                          outputStream.close();
//                                                                      } catch (Exception e) {
//                                                                          Toast.makeText(MainActivity.this, getString(R.string.error_file), Toast.LENGTH_SHORT).show();
//                                                                      }
//                                                                  }
//                                                              }
//                                                          }, 500);
//                            }else{
//                                String message = getString(R.string.empty_field);
//                                AlertDialog.Builder dialogError = new AlertDialog.Builder(MainActivity.this);
//                                dialogError.setMessage(message);
//                                dialogError.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        dialog.dismiss();
//                                        Toast.makeText(MainActivity.this, getString(R.string.toast_dummy), Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                                dialogError.create().show();
//                            }
//                        }
//                    }
//                });
//                dialog.create().show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
