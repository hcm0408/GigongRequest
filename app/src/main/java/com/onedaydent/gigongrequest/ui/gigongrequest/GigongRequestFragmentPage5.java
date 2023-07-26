package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.data.retrofit.GigongAPI;
import com.onedaydent.gigongrequest.data.retrofit.GigongClient;
import com.onedaydent.gigongrequest.databinding.DrawlayoutBinding;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest5Binding;
import com.onedaydent.gigongrequest.ui.DrawCanvas;
import com.onedaydent.gigongrequest.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GigongRequestFragmentPage5 extends Fragment implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemSelectedListener{

    private static String TAG = GigongRequestFragmentPage5.class.getSimpleName();
    private FragmentGigongrequest5Binding binding;
    private GigongRequestPage5ViewModel viewModel;
    private GigongRequestDTO dto = new GigongRequestDTO();
    private List<GigongOptionDTO> items = new ArrayList<GigongOptionDTO>();
    private DrawCanvas drawCanvas;
    private Dialog dialog;
    private FloatingActionButton fbPen;             //펜 모드 버튼
    private FloatingActionButton fbReset;             //펜 모드 버튼
    private FloatingActionButton fbEraser;          //지우개 모드 버튼
    private FloatingActionButton fbPaint;          //지우개 모드 버튼
    private ConstraintLayout canvasContainer;       //캔버스 root view
    private AppCompatButton request_save;
    private DrawlayoutBinding binding2;

    public GigongRequestFragmentPage5(){
        super();
        dto = new GigongRequestDTO();
        items = new ArrayList<GigongOptionDTO>(){{
            add(new GigongOptionDTO(11, 1));
            add(new GigongOptionDTO(12, 1));
            add(new GigongOptionDTO(13, 1));
            add(new GigongOptionDTO(14, 1));
            add(new GigongOptionDTO(15, 1));
            add(new GigongOptionDTO(16, 1));
            add(new GigongOptionDTO(17, 1));
            add(new GigongOptionDTO(21, 1));
            add(new GigongOptionDTO(22, 1));
            add(new GigongOptionDTO(23, 1));
            add(new GigongOptionDTO(34, 1));
            add(new GigongOptionDTO(35, 1));
            add(new GigongOptionDTO(46, 1));
            add(new GigongOptionDTO(47, 1));
        }};
        dto.setGr_ChartID("1807-302");
        dto.setGr_RequestDateTemp("2023-06-20");
        dto.setGr_Name("하창민");
        dto.setGr_hall(2);
        dto.setGr_dr_mb_name("김진환");
        dto.setGr_mb_name("노하정");
        dto.setGr_Shade(3);
        dto.setGr_Check2(1);
        dto.setGr_Check4(1);
        dto.setGr_Check6(1);
        dto.setGr_Check1(1);
        dto.setGr_Check8(1);
    }

    public GigongRequestFragmentPage5(GigongRequestDTO dto, List<GigongOptionDTO> items){
        super();
        this.dto = dto;
        this.items = items;
        items.removeIf(item -> item.getGo_Option() == 0);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            viewModel = new ViewModelProvider(this).get(GigongRequestPage5ViewModel.class);
            binding = FragmentGigongrequest5Binding.inflate(inflater, container, false);
            drawCanvas = new DrawCanvas(getContext(), dto.getTempBitmap());
            binding.request5Draw.setOnTouchListener(this::onTouch);
            Drawable drawable = new BitmapDrawable(getResources(), dto.getTempBitmap());
            binding.request5Draw.setBackground(drawable);
            viewModel.Init(getContext(), binding, this);
            listenerInit();
            setObserve();
            binding2 = DrawlayoutBinding.inflate(LayoutInflater.from(getContext()));
            fbPen = binding2.fbPen;
            fbEraser = binding2.fbEraser;
            fbReset = binding2.fbReset;
            fbPaint = binding2.fbPaint;
            request_save = binding2.requestSave;
            setOnClickListener();
            binding2.request5Draw.setBackground(drawable);
            binding2.request5Draw.addView(drawCanvas);

            this.dialog = new Dialog(getContext());
            dialog.setContentView(binding2.getRoot());
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.setCancelable(false);
            dialog.getWindow().setAttributes(layoutParams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        View root = binding.getRoot();
        return root;
    }

    private void setOnClickListener() {
        fbPen.setOnTouchListener((v, motionEvent) -> {
            if(motionEvent.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS && motionEvent.getAction() == MotionEvent.ACTION_UP) drawCanvas.changeTool(DrawCanvas.MODE_PEN);
            return true;
        });
        fbReset.setOnTouchListener((v, motionEvent) -> {
            if(motionEvent.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS && motionEvent.getAction() == MotionEvent.ACTION_UP) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("메모를 초기화 하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                drawCanvas.resetDraw();
                            }
                        }).setNegativeButton("취소", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            return true;
        });
        fbEraser.setOnTouchListener((v, motionEvent) -> {
            if(motionEvent.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS && motionEvent.getAction() == MotionEvent.ACTION_UP) drawCanvas.changeTool(DrawCanvas.MODE_ERASER);
            return true;
        });
        fbPaint.setOnTouchListener((v, motionEvent) -> {
            if(motionEvent.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS && motionEvent.getAction() == MotionEvent.ACTION_UP) {
                PopupMenu popupMenu = new PopupMenu(getContext(), v);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.color_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                drawCanvas.changeColor(Color.BLACK, 3);
                                break;
                            case R.id.menu2:
                                drawCanvas.changeColor(Color.BLUE, 3);
                                break;
                            case R.id.menu3:
                                drawCanvas.changeColor(Color.RED, 3);
                                break;
                            case R.id.menu4:
                                drawCanvas.changeColor(Color.GREEN, 3);
                                break;
                            default:
                                return false;
                        }
                        return true;
                    }
                });
            }
            return true;
        });
        request_save.setOnClickListener((v) ->{
            dto.setTempBitmap(drawCanvas.getCurrentCanvas());
            Drawable drawable = new BitmapDrawable(getResources(), dto.getTempBitmap());
            binding.request5Draw.setBackground(drawable);
            dialog.dismiss();
        });
    }

    public void listenerInit(){
        binding.grHall.setOnItemSelectedListener(this);
        binding.grGender.setOnItemSelectedListener(this);
        binding.grType.setOnItemSelectedListener(this);
        binding.request5Nextbtn.setOnClickListener(this);
        binding.grDrMbName.setOnItemSelectedListener(this);
        binding.grMbName.setOnItemSelectedListener(this);
    }

    private void setObserve(){
        viewModel.getDto().observe(getViewLifecycleOwner(), new Observer<GigongRequestDTO>() {
            @Override
            public void onChanged(GigongRequestDTO gigongRequestDTO) {
                binding.grRequestDateTemp.setText(!gigongRequestDTO.getGr_RequestDateTemp().equals("") && gigongRequestDTO.getGr_RequestDateTemp() != null ? gigongRequestDTO.getGr_RequestDateTemp() : "");
                binding.grChartID.setText(!gigongRequestDTO.getGr_ChartID().equals("") && gigongRequestDTO.getGr_ChartID() != null ? gigongRequestDTO.getGr_ChartID() : "");
                binding.grName.setText(!gigongRequestDTO.getGr_Name().equals("") && gigongRequestDTO.getGr_Name() != null ? gigongRequestDTO.getGr_Name() : "");
                binding.grHall.setSelection(gigongRequestDTO.getGr_hall() == 1 ? 0 : gigongRequestDTO.getGr_hall() == 2 ? 1 : 2);
                Optional<Integer> index = IntStream.range(0, viewModel.getDh().size())
                        .filter(i -> viewModel.getDr().get(i).getMb_name().equals(gigongRequestDTO.getGr_dr_mb_name()))
                        .boxed()
                        .findAny();
                Optional<Integer> index2 = IntStream.range(0, viewModel.getDh().size())
                        .filter(i -> viewModel.getDh().get(i).getMb_name().equals(gigongRequestDTO.getGr_mb_name()))
                        .boxed()
                        .findAny();
                binding.grMbName.setSelection(index.get());
                binding.grMbName.setSelection(index2.get());
                binding.grShade.setSelection(dto.getGr_Shade());
                binding.grCheck1.setChecked(dto.getGr_Check1() == 1 ? true : false);
                binding.grCheck2.setChecked(dto.getGr_Check2() == 1 ? true : false);
                binding.grCheck3.setChecked(dto.getGr_Check3() == 1 ? true : false);
                binding.grCheck4.setChecked(dto.getGr_Check4() == 1 ? true : false);
                binding.grCheck5.setChecked(dto.getGr_Check5() == 1 ? true : false);
                binding.grCheck6.setChecked(dto.getGr_Check6() == 1 ? true : false);
                binding.grCheck7.setChecked(dto.getGr_Check7() == 1 ? true : false);
                binding.grCheck8.setChecked(dto.getGr_Check8() == 1 ? true : false);
                binding.grCheck9.setChecked(dto.getGr_Check9() == 1 ? true : false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public GigongRequestDTO getDto() {
        return dto;
    }

    public List<GigongOptionDTO> getItems() {
        return items;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.request5_nextbtn:
                if (GigongClient.getInstance() != null){
                    GigongClient.getRetrofit().create(GigongAPI.class).setGigongOptionUpdate(items).enqueue(new Callback<LinkedList<GigongOptionDTO>>() {

                        @Override
                        public void onResponse(Call<LinkedList<GigongOptionDTO>> call, Response<LinkedList<GigongOptionDTO>> response) {
                            if(response.code() == 200){

                            }
                        }

                        @Override
                        public void onFailure(Call<LinkedList<GigongOptionDTO>> call, Throwable t) {
                            Utils.getMessageShort("기공물정보 저장 실패.\n관리자에게 문의하세요.");
                        }
                    });
                    try{
                        File file = new File(dto.getGr_ChartID() + "_" + dto.getGr_IDX() + ".jpg");
                        FileOutputStream out = new FileOutputStream(file);
                        dto.getTempBitmap().compress(Bitmap.CompressFormat.JPEG, 100, out);
                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        MultipartBody.Part uploadFile = MultipartBody.Part.createFormData("file", dto.getGr_ChartID() + "_" + dto.getGr_IDX() + ".jpg" , requestBody);
                        Log.d(TAG, "onClick: " + file.toString());
                        Log.d(TAG, "onClick:  " + dto.toString());
//                        GigongClient.getRetrofit().create(GigongAPI.class).saveGigongRequest(dto, uploadFile).enqueue(new Callback<GigongRequestDTO>() {
//                            @Override
//                            public void onResponse(Call<GigongRequestDTO> call, Response<GigongRequestDTO> response) {
//
//                            }
//
//                            @Override
//                            public void onFailure(Call<GigongRequestDTO> call, Throwable t) {
//                                Utils.getMessageShort("기공물정보 저장 실패.\n관리자에게 문의하세요.");
//                            }
//                        });
                    }catch (Exception e){
                        e.printStackTrace();
                    }

//
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(view.getId() == binding.grRequestDateTemp.getId() && motionEvent.getAction() == MotionEvent.ACTION_UP) {
            viewModel.openDatePicker(binding.grRequestDateTemp);
        }else if(view.getId() == binding.request5Draw.getId()){
            Drawable drawable = new BitmapDrawable(getResources(), dto.getTempBitmap());
            binding2.request5Draw.setBackground(drawable);
            dialog.show();
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()){
            case R.id.gr_hall:
                viewModel.getDto().getValue().setGr_hall(i + 1);
                break;
            case R.id.gr_Gender:
                viewModel.getDto().getValue().setGr_Gender(i);
                break;
            case R.id.gr_Type:
                viewModel.getDto().getValue().setGr_Type(i);
                break;
            case R.id.gr_dr_mb_name:
                viewModel.getDto().getValue().setGr_dr_mb_name(viewModel.getDr().get(i).getMb_name());
                viewModel.getDto().getValue().setGr_dr_mb_no(viewModel.getDr().get(i).getMb_no());
                break;
            case R.id.gr_mb_name:
                viewModel.getDto().getValue().setGr_mb_name(viewModel.getDh().get(i).getMb_name());
                viewModel.getDto().getValue().setGr_mb_no(viewModel.getDh().get(i).getMb_no());
                break;
            default :
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}