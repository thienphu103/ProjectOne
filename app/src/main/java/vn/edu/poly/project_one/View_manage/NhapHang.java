package vn.edu.poly.project_one.View_manage;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import vn.edu.poly.project_one.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ASUS on 12/1/2017.
 */

public class NhapHang extends Fragment {
    Button btn_continue, btn_gallary, btn_camera;
    View view_nhap_hang;
    EditText ten, gia, soluong, nsx, hsd, kichco, mota;
    String txt_ten, txt_gia, txt_soluong, txt_nsx, txt_hsd, txt_kichco, txt_mota;
    private String diachi_post;
    private String email_post;
    private String ten_post;
    private ImageView img_view_photo_nhaphang;
    private int CAMERA_REQUEST = 1;
    private int CAMERA_REQUEST_MAX = 1999;
    private Uri picUri;
    private int PIC_CROP = 3;
    private String URL_CALL_API_UP_DATA = "http://namtnps06077.hol.es/post_data_sanpham.php";
    private String URL_CALL_API_UPDATE_DATA = "http://namtnps06077.hol.es/update_data_sanpham.php";
    String txt_user;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private static final int PERMISSION_REQUEST_CAMERA = 0;
    private RelativeLayout layout_back_nhaphang;
    private int index_listview;
    private int index_listview_sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_nhap_hang = inflater.inflate(R.layout.fragment_nhap_hang_manage, container, false);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        return view_nhap_hang;
    }

    private void initOnClick() {
        final SharedPreferences sharedPreferences2 = getContext().getSharedPreferences("get_index_list_view_kho_hang", Context.MODE_PRIVATE);
        index_listview = sharedPreferences2.getInt("index_listview", 0);
        index_listview_sp = sharedPreferences2.getInt("id_sp", 0);
        String ten_sp = sharedPreferences2.getString("ten_sp", null);
        final String check = sharedPreferences2.getString("check_click", null);
        if (check != null) {
            ten.setText(ten_sp);
        }
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_ten = ten.getText().toString();
                txt_gia = gia.getText().toString();
                txt_soluong = soluong.getText().toString();
                txt_nsx = nsx.getText().toString();
                txt_hsd = hsd.getText().toString();
                txt_kichco = kichco.getText().toString();
                txt_mota = mota.getText().toString();
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("name_login", Context.MODE_PRIVATE);
                txt_user = sharedPreferences.getString("id_user", null);
                if (!(txt_ten.isEmpty())
                        && !(txt_gia.isEmpty())
                        && !(txt_soluong.isEmpty())
                        && !(txt_mota.isEmpty())) {
                    if (check != null) {
                        updataData();
                    } else {
                        upData();
                    }

                } else {
//
                    if ((txt_ten.isEmpty())) {
                        ten.setHint("*Xin vui lòng không bỏ trống");
                        ten.setHintTextColor(Color.RED);
                    }
                    if ((txt_gia.isEmpty())) {
                        gia.setHint("*Xin vui lòng không bỏ trống");
                        gia.setHintTextColor(Color.RED);
                    }
                    if ((txt_soluong.isEmpty())) {
                        soluong.setHint("*Xin vui lòng không bỏ trống");
                        soluong.setHintTextColor(Color.RED);
                    }

                    if ((txt_mota.isEmpty())) {
                        mota.setHint("*Xin vui lòng không bỏ trống");
                        mota.setHintTextColor(Color.RED);
                    }
                }
            }
        });
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (Build.VERSION.SDK_INT > 21) {
                        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                                == PackageManager.PERMISSION_GRANTED) {
                            // Permission is already available, start camera preview
                            Snackbar.make(view_nhap_hang,
                                    "Camera permission is available (API: " + Build.VERSION.SDK_INT + "). Starting preview.",
                                    Snackbar.LENGTH_SHORT).show();

                            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                                startActivityForResult(takePictureIntent, CAMERA_REQUEST_MAX);
                            }
                        } else {
                            // Permission is missing and must be requested.
                            requestCameraPermission();
                        }
                    } else {
                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(takePictureIntent, CAMERA_REQUEST);
                    }


//                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
//                            == PackageManager.PERMISSION_GRANTED) {
//                        // Permission is already available, start camera preview
//                        Snackbar.make(view_nhap_hang,
//                                "Camera permission is available. Starting preview.",
//                                Snackbar.LENGTH_SHORT).show();
//
//                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//                            startActivityForResult(takePictureIntent, CAMERA_REQUEST);
//                        }
//                    } else {
//                        // Permission is missing and must be requested.
//                        requestCameraPermission();
//                    }


                    // use standard intent to capture an image
                } catch (ActivityNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_gallary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent imageDownload = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                imageDownload.putExtra("crop", "true");
                imageDownload.putExtra("aspectX", 200);
                imageDownload.putExtra("aspectY", 200);
                imageDownload.putExtra("outputX", 200);
                imageDownload.putExtra("outputY", 200);
                imageDownload.putExtra("return-data", true);
                startActivityForResult(imageDownload, 2);
            }
        });
        layout_back_nhaphang.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                KhoHang view_nhap_hang = new KhoHang();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_layout_nhaphang, view_nhap_hang);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                return false;
            }
        });


    }


    private void initDisplay() {
    }

    private void initEvent() {


    }

    private void initUpdateUI() {
        ten.setText("");
        gia.setText("");
        soluong.setText("");
        nsx.setText("");
        hsd.setText("");
        kichco.setText("");
        mota.setText("");
        img_view_photo_nhaphang.setImageResource(R.drawable.ic_image);
    }

    private void performCrop() {
        // take care of exceptions
        try {
            // call the standard crop action intent (the user device may not
            // support it)
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            // indicate image type and Uri
            cropIntent.setDataAndType(picUri, "image/*");
            // set crop properties
            cropIntent.putExtra("crop", "true");
            // indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 200);
            cropIntent.putExtra("aspectY", 200);
            // indicate output X and Y
            cropIntent.putExtra("outputX", 200);
            cropIntent.putExtra("outputY", 200);
            // retrieve data on return
            cropIntent.putExtra("return-data", true);
            // start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, PIC_CROP);
        }
        // respond to users whose devices do not support the crop action
        catch (ActivityNotFoundException anfe) {

        }
    }


    private void initControl() {
        btn_continue = (Button) view_nhap_hang.findViewById(R.id.btn_nhaphang_nhaphang);
        ten = (EditText) view_nhap_hang.findViewById(R.id.edt_ten_sp_nhaphang);
        gia = (EditText) view_nhap_hang.findViewById(R.id.edt_gia_nhaphang);
        soluong = (EditText) view_nhap_hang.findViewById(R.id.edt_soluong_nhaphang);
        nsx = (EditText) view_nhap_hang.findViewById(R.id.edt_ngaysanxuat_nhaphang);
        hsd = (EditText) view_nhap_hang.findViewById(R.id.edt_hansudung__nhaphang);
        kichco = (EditText) view_nhap_hang.findViewById(R.id.edt_kichco_nhaphang);
        mota = (EditText) view_nhap_hang.findViewById(R.id.edt_mota_nhaphang);
        btn_camera = (Button) view_nhap_hang.findViewById(R.id.btn_camera_nhaphang);
        btn_gallary = (Button) view_nhap_hang.findViewById(R.id.btn_gallary_nhaphang);
        img_view_photo_nhaphang = (ImageView) view_nhap_hang.findViewById(R.id.img_view_photo_nhaphang);
        layout_back_nhaphang = (RelativeLayout) view_nhap_hang.findViewById(R.id.layout_back_nhaphang);


    }


    public void upData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_UP_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getContext(), "Data_User_" + txt_user + "|" + response.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "Nhập Hàng Thành Công", Toast.LENGTH_SHORT).show();

                initUpdateUI();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringMap = new HashMap<>();
                Bitmap bitmap = ((BitmapDrawable) img_view_photo_nhaphang.getDrawable()).getBitmap();
//                Bitmap image_fb = BitmapFactory.decodeStream(url_fb.openConnection().getInputStream());
                String image = decodeImage(bitmap);
                stringMap.put("ten_sp", txt_ten);
                stringMap.put("gia_sp", txt_gia);
                stringMap.put("mota_sp", txt_mota);
                stringMap.put("soluongdaban_sp", "0");
                stringMap.put("soluongconlai_sp", txt_soluong);
                stringMap.put("id_shop", txt_user);
                stringMap.put("id_loaisp", "Sản Phẩm");
                stringMap.put("id_danhgia_sp", "Tốt");
                stringMap.put("hinhanh_sp", image);
                stringMap.put("size_sp", txt_kichco);
                stringMap.put("mau_sp", "Đa sắc");
                stringMap.put("han_sd_sp", txt_nsx + " & " + txt_hsd);
                return stringMap;

            }

        };
        requestQueue.add(stringRequest);
    }

    public void updataData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_UPDATE_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "Data_User_" + txt_user + "|" + response.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
                initUpdateUI();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringMap = new HashMap<>();
                Bitmap bitmap = ((BitmapDrawable) img_view_photo_nhaphang.getDrawable()).getBitmap();
//                Bitmap image_fb = BitmapFactory.decodeStream(url_fb.openConnection().getInputStream());
                String image = decodeImage(bitmap);
                stringMap.put("ten_sp", txt_ten);
                stringMap.put("gia_sp", txt_gia);
                stringMap.put("mota_sp", txt_mota);
                stringMap.put("soluongdaban_sp", "0");
                stringMap.put("soluongconlai_sp", txt_soluong);
                stringMap.put("id_shop", txt_user);
                stringMap.put("id_loaisp", "Sản Phẩm");
                stringMap.put("id_danhgia_sp", "Tốt");
                stringMap.put("hinhanh_sp", image);
                stringMap.put("size_sp", txt_kichco);
                stringMap.put("mau_sp", "Đa sắc");
                stringMap.put("han_sd_sp", txt_nsx + " & " + txt_hsd);
                stringMap.put("txt_id", String.valueOf(index_listview_sp));
                return stringMap;

            }
        };

        requestQueue.add(stringRequest);
    }

    public String decodeImage(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] byteImage = outputStream.toByteArray();
        String encodeImage = Base64.encodeToString(byteImage, Base64.DEFAULT);
        return encodeImage;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            Bitmap image = extras.getParcelable("data");
            img_view_photo_nhaphang.setImageBitmap(image);
        }
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                // get the Uri for the captured image
                picUri = data.getData();
                performCrop();
            } else if (requestCode == CAMERA_REQUEST_MAX) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                img_view_photo_nhaphang.setImageBitmap(imageBitmap);
            }

            // user is returning from cropping the image
            else if (requestCode == PIC_CROP) {
                // get the returned data
                Bundle extras = data.getExtras();
                // get the cropped bitmap
                Bitmap thePic = extras.getParcelable("data");
                img_view_photo_nhaphang.setImageBitmap(thePic);
            }


        }
    }

    private void requestCameraPermission() {
        // Permission has not been granted and must be requested.
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.CAMERA)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with a button to request the missing permission.
            Snackbar.make(view_nhap_hang, "Camera access is required to display the camera preview.",
                    Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CAMERA},
                            PERMISSION_REQUEST_CAMERA);
                }
            }).show();

        } else {
            Snackbar.make(view_nhap_hang,
                    "Permission is not available. Requesting camera permission.",
                    Snackbar.LENGTH_SHORT).show();
            // Request the permission. The result will be received in onRequestPermissionResult().
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA},
                    PERMISSION_REQUEST_CAMERA);
        }
    }

}
