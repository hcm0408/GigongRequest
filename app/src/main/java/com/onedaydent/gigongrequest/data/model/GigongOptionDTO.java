package com.onedaydent.gigongrequest.data.model;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class GigongOptionDTO implements Cloneable {
    private int go_IDX;					// IDX
    private int go_gr_IDX;				// 의뢰서 IDX
    private int go_ToothNumber;			// 치식 11, 12, 13...etc..
    private int go_Option;				// 의뢰내용		1. Zirconia, 2 PFM, 3. PMMA
    private int go_Option1;				// Fixture		1. Oneday, 2. Osstem, 3. Dentis, 4. Dentium, 5. Dentium, 6. Astra
    private int go_Option2;				// Coping		0.
    private int go_Option3;				// Custom		1. X, 2. △, 3. O
    private int go_Option4;				// Scan type 	1. X, 2. TRIOS, 3. RAYOS
    private int go_Option5;				// Cement Type, Scrp Type, Screw Type
    private int go_Option6;				// next
    private String go_Option7;			// healing size
    private int go_Option7_p;           // healing position;
    private int go_Option8;				// ??
    private String go_Option9;			//
    private TextView circle;            //
    private boolean isSelected;         // 선택여부 확인
    private int go_isBridge = 1;        // 브릿지여부
    private int go_isBridge2 = 1;       // 브릿지여부
    private ImageButton bridge;         // 브릿지여부
    private View line;                  // line

    private ImageButton bridge2;        // 가운데 브릿지
    private View line2;                 // 가운데 line

    public void reset(){
        go_Option1 = 0;
        go_Option2 = 0;
        go_Option3 = 0;
        go_Option4 = 0;
        go_Option5 = 0;
        go_Option6 = 0;
        go_Option7 = "";
        go_Option7_p = 0;
        go_isBridge = 1;
        go_isBridge2 = 1;
        circle.setText(go_ToothNumber % 10 + "");
        isSelected = false;
    }

    public void reset(Drawable bridgeCircle){
        go_Option1 = 0;
        go_Option2 = 0;
        go_Option3 = 0;
        go_Option4 = 0;
        go_Option5 = 0;
        go_Option6 = 0;
        go_Option7 = "";
        go_Option7_p = 0;
        go_isBridge = 1;
        go_isBridge2 = 1;
        isSelected = false;
        circle.setText(go_ToothNumber % 10 + "");
        if(getBridge() != null){
            getBridge().setVisibility(View.INVISIBLE);
            getBridge().setBackground(bridgeCircle);
            getLine().setVisibility(View.INVISIBLE);
        }
        if(getBridge2() != null){
            getBridge2().setVisibility(View.INVISIBLE);
            getBridge2().setBackground(bridgeCircle);
            getLine2().setVisibility(View.INVISIBLE);
        }
    }

    public void setCopy(GigongOptionDTO copy){
        go_Option = copy.getGo_Option();
        go_Option1 = copy.getGo_Option1();
        go_Option2 = copy.getGo_Option2();
        go_Option3 = copy.getGo_Option3();
        go_Option4 = copy.getGo_Option4();
        go_Option5 = copy.getGo_Option5();
        go_Option6 = copy.getGo_Option6();
        go_Option7 = copy.getGo_Option7();
        go_Option7_p = copy.getGo_Option7_p();
        if(go_Option == 4) circle.setText("x");
        else circle.setText(go_ToothNumber % 10 + "");
        isSelected = false;
    }

    public void setPontic(){
        go_Option = 4;
        go_Option1 = 0;
        go_Option2 = 0;
        go_Option3 = 0;
        go_Option4 = 0;
        go_Option5 = 0;
        go_Option6 = 0;
        go_Option7 = "";
        go_Option7_p = 0;
        go_isBridge = 1;
        go_isBridge2 = 1;
        isSelected = false;
        circle.setText("x");
    }

    public GigongOptionDTO() {
        super();
        go_Option7 = "";
        isSelected = false;
    }

    public GigongOptionDTO(int go_ToothNumber, int go_Option) {
        this.go_ToothNumber = go_ToothNumber;
        this.go_Option = go_Option;
        this.go_Option5 = 1;
        this.go_Option3 = 1;
        this.go_Option2 = 1;
        this.go_Option1 = 1;
        this.go_Option6 = 3;
        this.go_Option7 = "4.0x4.5";
        this.go_Option7_p = 3;
    }

    public GigongOptionDTO(TextView circle, int go_ToothNumber) {
        this.circle = circle;
        this.go_ToothNumber = go_ToothNumber;
    }

    public GigongOptionDTO(TextView circle, int go_ToothNumber, ImageButton bridge, View line, ImageButton bridge2, View line2, Drawable circleChoice) {
        this.circle = circle;
        this.go_ToothNumber = go_ToothNumber;
        this.go_isBridge = 1;
        this.go_isBridge2 = 1;
        this.bridge = bridge;
        if(this.bridge != null) this.bridge.setBackground(circleChoice);
        this.line = line;
        if(this.line != null) this.line.setVisibility(View.INVISIBLE);
        this.bridge2 = bridge2;
        if(this.bridge2 != null) this.bridge2.setBackground(circleChoice);
        this.line2 = line2;
        if(this.line2 != null) this.line2.setVisibility(View.INVISIBLE);
        this.go_Option1 = 0;
        this.go_Option2 = 0;
        this.go_Option3 = 0;
        this.go_Option4 = 0;
        this.go_Option5 = 0;
        this.go_Option6 = 0;
        this.go_Option7 = "";
        this.go_Option7_p = 0;
        this.isSelected = false;
//        circle.setText(go_ToothNumber % 10 + "");
    }

    public int getGo_IDX() {
        return this.go_IDX;
    }

    public int getGo_gr_IDX() {
        return this.go_gr_IDX;
    }

    public int getGo_ToothNumber() {
        return this.go_ToothNumber;
    }

    public int getGo_Option() {
        return this.go_Option;
    }

    public int getGo_Option1() {
        return this.go_Option1;
    }

    public int getGo_Option2() {
        return this.go_Option2;
    }

    public int getGo_Option3() {
        return this.go_Option3;
    }

    public int getGo_Option4() {
        return this.go_Option4;
    }

    public int getGo_Option5() {
        return this.go_Option5;
    }

    public int getGo_Option6() {
        return this.go_Option6;
    }

    public String getGo_Option7() {
        return this.go_Option7;
    }

    public int getGo_Option7_p() {
        return this.go_Option7_p;
    }

    public int getGo_Option8() {
        return this.go_Option8;
    }

    public String getGo_Option9() {
        return this.go_Option9;
    }

    public TextView getCircle() {
        return this.circle;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public int getGo_isBridge() {
        return this.go_isBridge;
    }

    public int getGo_isBridge2() {
        return this.go_isBridge2;
    }

    public ImageButton getBridge() {
        return this.bridge;
    }

    public View getLine() {
        return this.line;
    }

    public ImageButton getBridge2() {
        return this.bridge2;
    }

    public View getLine2() {
        return this.line2;
    }

    public void setGo_IDX(int go_IDX) {
        this.go_IDX = go_IDX;
    }

    public void setGo_gr_IDX(int go_gr_IDX) {
        this.go_gr_IDX = go_gr_IDX;
    }

    public void setGo_ToothNumber(int go_ToothNumber) {
        this.go_ToothNumber = go_ToothNumber;
    }

    public void setGo_Option(int go_Option) {
        this.go_Option = go_Option;
    }

    public void setGo_Option1(int go_Option1) {
        this.go_Option1 = go_Option1;
    }

    public void setGo_Option2(int go_Option2) {
        this.go_Option2 = go_Option2;
    }

    public void setGo_Option3(int go_Option3) {
        this.go_Option3 = go_Option3;
    }

    public void setGo_Option4(int go_Option4) {
        this.go_Option4 = go_Option4;
    }

    public void setGo_Option5(int go_Option5) {
        this.go_Option5 = go_Option5;
    }

    public void setGo_Option6(int go_Option6) {
        this.go_Option6 = go_Option6;
    }

    public void setGo_Option7(String go_Option7) {
        this.go_Option7 = go_Option7;
    }

    public void setGo_Option7_p(int go_Option7_p) {
        this.go_Option7_p = go_Option7_p;
    }

    public void setGo_Option8(int go_Option8) {
        this.go_Option8 = go_Option8;
    }

    public void setGo_Option9(String go_Option9) {
        this.go_Option9 = go_Option9;
    }

    public void setCircle(TextView circle) {
        this.circle = circle;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public void setGo_isBridge(int go_isBridge) {
        this.go_isBridge = go_isBridge;
    }

    public void setGo_isBridge2(int go_isBridge2) {
        this.go_isBridge2 = go_isBridge2;
    }

    public void setBridge(ImageButton bridge) {
        this.bridge = bridge;
    }

    public void setLine(View line) {
        this.line = line;
    }

    public void setBridge2(ImageButton bridge2) {
        this.bridge2 = bridge2;
    }

    public void setLine2(View line2) {
        this.line2 = line2;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GigongOptionDTO)) return false;
        final GigongOptionDTO other = (GigongOptionDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getGo_IDX() != other.getGo_IDX()) return false;
        if (this.getGo_gr_IDX() != other.getGo_gr_IDX()) return false;
        if (this.getGo_ToothNumber() != other.getGo_ToothNumber()) return false;
        if (this.getGo_Option() != other.getGo_Option()) return false;
        if (this.getGo_Option1() != other.getGo_Option1()) return false;
        if (this.getGo_Option2() != other.getGo_Option2()) return false;
        if (this.getGo_Option3() != other.getGo_Option3()) return false;
        if (this.getGo_Option4() != other.getGo_Option4()) return false;
        if (this.getGo_Option5() != other.getGo_Option5()) return false;
        if (this.getGo_Option6() != other.getGo_Option6()) return false;
        final Object this$go_Option7 = this.getGo_Option7();
        final Object other$go_Option7 = other.getGo_Option7();
        if (this$go_Option7 == null ? other$go_Option7 != null : !this$go_Option7.equals(other$go_Option7))
            return false;
        if (this.getGo_Option7_p() != other.getGo_Option7_p()) return false;
        if (this.getGo_Option8() != other.getGo_Option8()) return false;
        final Object this$go_Option9 = this.getGo_Option9();
        final Object other$go_Option9 = other.getGo_Option9();
        if (this$go_Option9 == null ? other$go_Option9 != null : !this$go_Option9.equals(other$go_Option9))
            return false;
        final Object this$circle = this.getCircle();
        final Object other$circle = other.getCircle();
        if (this$circle == null ? other$circle != null : !this$circle.equals(other$circle))
            return false;
        if (this.isSelected() != other.isSelected()) return false;
        if (this.getGo_isBridge() != other.getGo_isBridge()) return false;
        if (this.getGo_isBridge2() != other.getGo_isBridge2()) return false;
        final Object this$bridge = this.getBridge();
        final Object other$bridge = other.getBridge();
        if (this$bridge == null ? other$bridge != null : !this$bridge.equals(other$bridge))
            return false;
        final Object this$line = this.getLine();
        final Object other$line = other.getLine();
        if (this$line == null ? other$line != null : !this$line.equals(other$line)) return false;
        final Object this$bridge2 = this.getBridge2();
        final Object other$bridge2 = other.getBridge2();
        if (this$bridge2 == null ? other$bridge2 != null : !this$bridge2.equals(other$bridge2))
            return false;
        final Object this$line2 = this.getLine2();
        final Object other$line2 = other.getLine2();
        if (this$line2 == null ? other$line2 != null : !this$line2.equals(other$line2))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GigongOptionDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getGo_IDX();
        result = result * PRIME + this.getGo_gr_IDX();
        result = result * PRIME + this.getGo_ToothNumber();
        result = result * PRIME + this.getGo_Option();
        result = result * PRIME + this.getGo_Option1();
        result = result * PRIME + this.getGo_Option2();
        result = result * PRIME + this.getGo_Option3();
        result = result * PRIME + this.getGo_Option4();
        result = result * PRIME + this.getGo_Option5();
        result = result * PRIME + this.getGo_Option6();
        final Object $go_Option7 = this.getGo_Option7();
        result = result * PRIME + ($go_Option7 == null ? 43 : $go_Option7.hashCode());
        result = result * PRIME + this.getGo_Option7_p();
        result = result * PRIME + this.getGo_Option8();
        final Object $go_Option9 = this.getGo_Option9();
        result = result * PRIME + ($go_Option9 == null ? 43 : $go_Option9.hashCode());
        final Object $circle = this.getCircle();
        result = result * PRIME + ($circle == null ? 43 : $circle.hashCode());
        result = result * PRIME + (this.isSelected() ? 79 : 97);
        result = result * PRIME + this.getGo_isBridge();
        result = result * PRIME + this.getGo_isBridge2();
        final Object $bridge = this.getBridge();
        result = result * PRIME + ($bridge == null ? 43 : $bridge.hashCode());
        final Object $line = this.getLine();
        result = result * PRIME + ($line == null ? 43 : $line.hashCode());
        final Object $bridge2 = this.getBridge2();
        result = result * PRIME + ($bridge2 == null ? 43 : $bridge2.hashCode());
        final Object $line2 = this.getLine2();
        result = result * PRIME + ($line2 == null ? 43 : $line2.hashCode());
        return result;
    }

    @NonNull
    @Override
    public GigongOptionDTO clone() {
        try{
            GigongOptionDTO temp = (GigongOptionDTO)super.clone();
            if(temp.getGo_Option7() == null) temp.setGo_Option7("");
            return temp;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "GigongOptionDTO(go_IDX=" + this.getGo_IDX() + ", go_gr_IDX=" + this.getGo_gr_IDX() + ", go_ToothNumber=" + this.getGo_ToothNumber() + ", go_Option=" + this.getGo_Option() + ", go_Option1=" + this.getGo_Option1() + ", go_Option2=" + this.getGo_Option2() + ", go_Option3=" + this.getGo_Option3() + ", go_Option4=" + this.getGo_Option4() + ", go_Option5=" + this.getGo_Option5() + ", go_Option6=" + this.getGo_Option6() + ", go_Option7=" + this.getGo_Option7() + ", go_Option7_p=" + this.getGo_Option7_p() + ", go_Option8=" + this.getGo_Option8() + ", go_Option9=" + this.getGo_Option9() + ", circle=" + this.getCircle() + ", isSelected=" + this.isSelected() + ", go_isBridge=" + this.getGo_isBridge() + ", go_isBridge2=" + this.getGo_isBridge2() + ", bridge=" + this.getBridge() + ", line=" + this.getLine() + ", bridge2=" + this.getBridge2() + ", line2=" + this.getLine2() + ")";
    }
}
