package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;
import com.onedaydent.gigongrequest.databinding.OptionLayoutBinding;
import com.onedaydent.gigongrequest.utils.COMPONENTENUM;
import com.onedaydent.gigongrequest.utils.OPTIONENUM;

import java.util.ArrayList;
import java.util.List;

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.ViewHolder> {
    private static String TAG = OptionAdapter.class.getSimpleName();
    private List<GigongOptionDTO> items = new ArrayList<GigongOptionDTO>();
    private Dialog dialog = null;
    private OptionLayoutBinding bindingOption = null;
    private COMPONENTENUM componentEnum = null;
    private GigongRequestPage5ViewModel model = null;

    public OptionAdapter(List<GigongOptionDTO> items, GigongRequestPage5ViewModel model, Dialog dialog, OptionLayoutBinding bindingOption, COMPONENTENUM componentEnum){
        this.items = items;
        this.dialog = dialog;
        this.bindingOption = bindingOption;
        this.componentEnum = componentEnum;
        this.model = model;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public OptionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.optionsitem, parent, false);
        OptionAdapter.ViewHolder vh = new OptionAdapter.ViewHolder(view);
        vh.setIsRecyclable(false);
        return vh;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(OptionAdapter.ViewHolder holder, int position) {
        GigongOptionDTO item = items.get(position);
        holder.toothNumber.setText(item.getGo_ToothNumber() + "");
        holder.option.setText(OPTIONENUM.optionStr.get(item.getGo_Option()) + "");
        holder.option7.setText(item.getGo_Option7() != null ? item.getGo_Option7() : "");
        holder.option6.setText(OPTIONENUM.option6Str.get(item.getGo_Option6()));
        holder.option1.setText(OPTIONENUM.option1Str.get(item.getGo_Option1()));
        holder.option2.setText(OPTIONENUM.option2Str.get(item.getGo_Option2()));
        holder.option3.setText(OPTIONENUM.option3Str.get(item.getGo_Option3()));
        holder.option4.setText(OPTIONENUM.option4Str.get(item.getGo_Option4()));
        holder.option5.setText(OPTIONENUM.option5Str.get(item.getGo_Option5()));
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView toothNumber, option, option1, option2, option3, option4, option5, option6, option7;
        MaterialCardView item;

        public ViewHolder(View itemView) {
            super(itemView);
            // 뷰 객체에 대한 참조. (hold strong reference)
            toothNumber = itemView.findViewById(R.id.toothNumber);
            option = itemView.findViewById(R.id.option);
            option7 = itemView.findViewById(R.id.option7);
            option6 = itemView.findViewById(R.id.option6);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
            option5 = itemView.findViewById(R.id.option5);
            item = itemView.findViewById(R.id.item);
            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            GigongOptionDTO item = items.get(pos);
            model.setOption(item);
            componentEnum.getSpinners().forEach(temp -> {
                temp.setVisibility(View.INVISIBLE);
                temp.setSelection(0);
            });
            componentEnum.choiceSpinner(item, true);
            bindingOption.requestOption.setSelection(item.getGo_Option());
            bindingOption.requestOption1.setSelection(item.getGo_Option1());
            bindingOption.requestOption2.setSelection(item.getGo_Option2());
            bindingOption.requestOption3.setSelection(item.getGo_Option3());
            bindingOption.requestOption4.setSelection(item.getGo_Option4());
            bindingOption.requestOption5.setSelection(item.getGo_Option5());
            bindingOption.requestOption6.setSelection(item.getGo_Option6());
            dialog.show();
        }
    }
}
