package com.onedaydent.gigongrequest.data.model;

import android.graphics.Bitmap;

import java.util.Date;

public class GigongRequestDTO {
    private static String TAG = GigongRequestDTO.class.getSimpleName();
    /* 기본정보 */
    private int gr_IDX;						// 인덱스
    private int gr_original_IDX;			// 기공의뢰서 원본 IDX *여러가지 가 겹쳐 있을 경우 ex) 1번에서 복사시 2번 gr_IDX 생성되고 original_IDX = 1, 2번복사시 gr_IDX 3번 생성 original_IDX = 2
    private int gr_hall;					// 관
    private int gr_dr_mb_no; 				// Dr no
    private String gr_dr_mb_name;			// Dr 이름
    private int gr_mb_no; 					// 위생사 no
    private String gr_mb_name;				// 위생사 이름
    private int gr_gigong_mb_no;			// 기공사 no
    private String gr_gigong_mb_name;		// 기공사 이름
    private String gr_check_mb_no;			// 팀장 no
    private int gr_check_mb_name;			// 팀장 이름
    private String gr_Name;					// 환자성함
    private Date gr_RequestDate;			// 접수일
    private int gr_Gender;					// 성별 0 = 남자, 1 = 여자
    private String gr_ChartID;				// 차트번호
    private Date gr_CompleteDate;			// 완성일
    private String gr_CompleteDateTime;		// 완성일 시간
    private int gr_Complete;				// 0 = 작성, 1 = 확인, 2 = 완성
    private int gr_Type;					// 0 = 일반, 1 = 당일, 2 = 1박2일
    private int gr_isCheckComplete;         // 기공물 담당자 확인 0 미확인 1확인
    private String gr_IMGUrl;				// 펜으로 작성한 내용 IMG화
    private Bitmap tempBitmap;              // 펜트로 작성한 내용 임시 저장

    /* 옵션 */
    private int gr_Shade;					// 쉐이드
    private int gr_Check1;					// 바이트
    private int gr_Check2;					// 대합치
    private int gr_Check3;					// 지그
    private int gr_Check4;					// 동공사진
    private int gr_Check5;					// 지대치사진
    private int gr_Check6;					// 쉐이드사진
    private int gr_Check7;					// 당일 2nd op
    private int gr_Check8;					// gum porcelain
    private int gr_Check9;					// abut margin
    private int gr_Check10;					// face scan
    private String gr_WriteField;			// 글 작성 필드
    private int gr_Valid;					// 사용여부 0. 사용, 1. 삭제

    /* 피드백 영역 */
    private int gr_Contact;					// Contact 조절
    private int gr_Bite;					// Bite 조절
    private int gr_CementType;				// Cement Type 조절
    private int gr_ScrewHole;				// Screw Hole 조절

    private String gr_RequestDateTemp;
    private String gr_CompleteDateTemp;

    public GigongRequestDTO() {
    }

    public int getGr_IDX() {
        return this.gr_IDX;
    }

    public int getGr_original_IDX() {
        return this.gr_original_IDX;
    }

    public int getGr_hall() {
        return this.gr_hall;
    }

    public int getGr_dr_mb_no() {
        return this.gr_dr_mb_no;
    }

    public String getGr_dr_mb_name() {
        return this.gr_dr_mb_name;
    }

    public int getGr_mb_no() {
        return this.gr_mb_no;
    }

    public String getGr_mb_name() {
        return this.gr_mb_name;
    }

    public int getGr_gigong_mb_no() {
        return this.gr_gigong_mb_no;
    }

    public String getGr_gigong_mb_name() {
        return this.gr_gigong_mb_name;
    }

    public String getGr_check_mb_no() {
        return this.gr_check_mb_no;
    }

    public int getGr_check_mb_name() {
        return this.gr_check_mb_name;
    }

    public String getGr_Name() {
        return this.gr_Name;
    }

    public Date getGr_RequestDate() {
        return this.gr_RequestDate;
    }

    public int getGr_Gender() {
        return this.gr_Gender;
    }

    public String getGr_ChartID() {
        return this.gr_ChartID;
    }

    public Date getGr_CompleteDate() {
        return this.gr_CompleteDate;
    }

    public String getGr_CompleteDateTime() {
        return this.gr_CompleteDateTime;
    }

    public int getGr_Complete() {
        return this.gr_Complete;
    }

    public int getGr_Type() {
        return this.gr_Type;
    }

    public int getGr_isCheckComplete() {
        return this.gr_isCheckComplete;
    }

    public String getGr_IMGUrl() {
        return this.gr_IMGUrl;
    }

    public Bitmap getTempBitmap() {
        return this.tempBitmap;
    }

    public int getGr_Shade() {
        return this.gr_Shade;
    }

    public int getGr_Check1() {
        return this.gr_Check1;
    }

    public int getGr_Check2() {
        return this.gr_Check2;
    }

    public int getGr_Check3() {
        return this.gr_Check3;
    }

    public int getGr_Check4() {
        return this.gr_Check4;
    }

    public int getGr_Check5() {
        return this.gr_Check5;
    }

    public int getGr_Check6() {
        return this.gr_Check6;
    }

    public int getGr_Check7() {
        return this.gr_Check7;
    }

    public int getGr_Check8() {
        return this.gr_Check8;
    }

    public int getGr_Check9() {
        return this.gr_Check9;
    }

    public int getGr_Check10() {
        return this.gr_Check10;
    }

    public String getGr_WriteField() {
        return this.gr_WriteField;
    }

    public int getGr_Valid() {
        return this.gr_Valid;
    }

    public int getGr_Contact() {
        return this.gr_Contact;
    }

    public int getGr_Bite() {
        return this.gr_Bite;
    }

    public int getGr_CementType() {
        return this.gr_CementType;
    }

    public int getGr_ScrewHole() {
        return this.gr_ScrewHole;
    }

    public String getGr_RequestDateTemp() {
        return this.gr_RequestDateTemp;
    }

    public String getGr_CompleteDateTemp() {
        return this.gr_CompleteDateTemp;
    }

    public void setGr_IDX(int gr_IDX) {
        this.gr_IDX = gr_IDX;
    }

    public void setGr_original_IDX(int gr_original_IDX) {
        this.gr_original_IDX = gr_original_IDX;
    }

    public void setGr_hall(int gr_hall) {
        this.gr_hall = gr_hall;
    }

    public void setGr_dr_mb_no(int gr_dr_mb_no) {
        this.gr_dr_mb_no = gr_dr_mb_no;
    }

    public void setGr_dr_mb_name(String gr_dr_mb_name) {
        this.gr_dr_mb_name = gr_dr_mb_name;
    }

    public void setGr_mb_no(int gr_mb_no) {
        this.gr_mb_no = gr_mb_no;
    }

    public void setGr_mb_name(String gr_mb_name) {
        this.gr_mb_name = gr_mb_name;
    }

    public void setGr_gigong_mb_no(int gr_gigong_mb_no) {
        this.gr_gigong_mb_no = gr_gigong_mb_no;
    }

    public void setGr_gigong_mb_name(String gr_gigong_mb_name) {
        this.gr_gigong_mb_name = gr_gigong_mb_name;
    }

    public void setGr_check_mb_no(String gr_check_mb_no) {
        this.gr_check_mb_no = gr_check_mb_no;
    }

    public void setGr_check_mb_name(int gr_check_mb_name) {
        this.gr_check_mb_name = gr_check_mb_name;
    }

    public void setGr_Name(String gr_Name) {
        this.gr_Name = gr_Name;
    }

    public void setGr_RequestDate(Date gr_RequestDate) {
        this.gr_RequestDate = gr_RequestDate;
    }

    public void setGr_Gender(int gr_Gender) {
        this.gr_Gender = gr_Gender;
    }

    public void setGr_ChartID(String gr_ChartID) {
        this.gr_ChartID = gr_ChartID;
    }

    public void setGr_CompleteDate(Date gr_CompleteDate) {
        this.gr_CompleteDate = gr_CompleteDate;
    }

    public void setGr_CompleteDateTime(String gr_CompleteDateTime) {
        this.gr_CompleteDateTime = gr_CompleteDateTime;
    }

    public void setGr_Complete(int gr_Complete) {
        this.gr_Complete = gr_Complete;
    }

    public void setGr_Type(int gr_Type) {
        this.gr_Type = gr_Type;
    }

    public void setGr_isCheckComplete(int gr_isCheckComplete) {
        this.gr_isCheckComplete = gr_isCheckComplete;
    }

    public void setGr_IMGUrl(String gr_IMGUrl) {
        this.gr_IMGUrl = gr_IMGUrl;
    }

    public void setTempBitmap(Bitmap tempBitmap) {
        this.tempBitmap = tempBitmap;
    }

    public void setGr_Shade(int gr_Shade) {
        this.gr_Shade = gr_Shade;
    }

    public void setGr_Check1(int gr_Check1) {
        this.gr_Check1 = gr_Check1;
    }

    public void setGr_Check2(int gr_Check2) {
        this.gr_Check2 = gr_Check2;
    }

    public void setGr_Check3(int gr_Check3) {
        this.gr_Check3 = gr_Check3;
    }

    public void setGr_Check4(int gr_Check4) {
        this.gr_Check4 = gr_Check4;
    }

    public void setGr_Check5(int gr_Check5) {
        this.gr_Check5 = gr_Check5;
    }

    public void setGr_Check6(int gr_Check6) {
        this.gr_Check6 = gr_Check6;
    }

    public void setGr_Check7(int gr_Check7) {
        this.gr_Check7 = gr_Check7;
    }

    public void setGr_Check8(int gr_Check8) {
        this.gr_Check8 = gr_Check8;
    }

    public void setGr_Check9(int gr_Check9) {
        this.gr_Check9 = gr_Check9;
    }

    public void setGr_Check10(int gr_Check10) {
        this.gr_Check10 = gr_Check10;
    }

    public void setGr_WriteField(String gr_WriteField) {
        this.gr_WriteField = gr_WriteField;
    }

    public void setGr_Valid(int gr_Valid) {
        this.gr_Valid = gr_Valid;
    }

    public void setGr_Contact(int gr_Contact) {
        this.gr_Contact = gr_Contact;
    }

    public void setGr_Bite(int gr_Bite) {
        this.gr_Bite = gr_Bite;
    }

    public void setGr_CementType(int gr_CementType) {
        this.gr_CementType = gr_CementType;
    }

    public void setGr_ScrewHole(int gr_ScrewHole) {
        this.gr_ScrewHole = gr_ScrewHole;
    }

    public void setGr_RequestDateTemp(String gr_RequestDateTemp) {
        this.gr_RequestDateTemp = gr_RequestDateTemp;
    }

    public void setGr_CompleteDateTemp(String gr_CompleteDateTemp) {
        this.gr_CompleteDateTemp = gr_CompleteDateTemp;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GigongRequestDTO)) return false;
        final GigongRequestDTO other = (GigongRequestDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getGr_IDX() != other.getGr_IDX()) return false;
        if (this.getGr_original_IDX() != other.getGr_original_IDX()) return false;
        if (this.getGr_hall() != other.getGr_hall()) return false;
        if (this.getGr_dr_mb_no() != other.getGr_dr_mb_no()) return false;
        final Object this$gr_dr_mb_name = this.getGr_dr_mb_name();
        final Object other$gr_dr_mb_name = other.getGr_dr_mb_name();
        if (this$gr_dr_mb_name == null ? other$gr_dr_mb_name != null : !this$gr_dr_mb_name.equals(other$gr_dr_mb_name))
            return false;
        if (this.getGr_mb_no() != other.getGr_mb_no()) return false;
        final Object this$gr_mb_name = this.getGr_mb_name();
        final Object other$gr_mb_name = other.getGr_mb_name();
        if (this$gr_mb_name == null ? other$gr_mb_name != null : !this$gr_mb_name.equals(other$gr_mb_name))
            return false;
        if (this.getGr_gigong_mb_no() != other.getGr_gigong_mb_no()) return false;
        final Object this$gr_gigong_mb_name = this.getGr_gigong_mb_name();
        final Object other$gr_gigong_mb_name = other.getGr_gigong_mb_name();
        if (this$gr_gigong_mb_name == null ? other$gr_gigong_mb_name != null : !this$gr_gigong_mb_name.equals(other$gr_gigong_mb_name))
            return false;
        final Object this$gr_check_mb_no = this.getGr_check_mb_no();
        final Object other$gr_check_mb_no = other.getGr_check_mb_no();
        if (this$gr_check_mb_no == null ? other$gr_check_mb_no != null : !this$gr_check_mb_no.equals(other$gr_check_mb_no))
            return false;
        if (this.getGr_check_mb_name() != other.getGr_check_mb_name()) return false;
        final Object this$gr_Name = this.getGr_Name();
        final Object other$gr_Name = other.getGr_Name();
        if (this$gr_Name == null ? other$gr_Name != null : !this$gr_Name.equals(other$gr_Name))
            return false;
        final Object this$gr_RequestDate = this.getGr_RequestDate();
        final Object other$gr_RequestDate = other.getGr_RequestDate();
        if (this$gr_RequestDate == null ? other$gr_RequestDate != null : !this$gr_RequestDate.equals(other$gr_RequestDate))
            return false;
        if (this.getGr_Gender() != other.getGr_Gender()) return false;
        final Object this$gr_ChartID = this.getGr_ChartID();
        final Object other$gr_ChartID = other.getGr_ChartID();
        if (this$gr_ChartID == null ? other$gr_ChartID != null : !this$gr_ChartID.equals(other$gr_ChartID))
            return false;
        final Object this$gr_CompleteDate = this.getGr_CompleteDate();
        final Object other$gr_CompleteDate = other.getGr_CompleteDate();
        if (this$gr_CompleteDate == null ? other$gr_CompleteDate != null : !this$gr_CompleteDate.equals(other$gr_CompleteDate))
            return false;
        final Object this$gr_CompleteDateTime = this.getGr_CompleteDateTime();
        final Object other$gr_CompleteDateTime = other.getGr_CompleteDateTime();
        if (this$gr_CompleteDateTime == null ? other$gr_CompleteDateTime != null : !this$gr_CompleteDateTime.equals(other$gr_CompleteDateTime))
            return false;
        if (this.getGr_Complete() != other.getGr_Complete()) return false;
        if (this.getGr_Type() != other.getGr_Type()) return false;
        if (this.getGr_isCheckComplete() != other.getGr_isCheckComplete()) return false;
        final Object this$gr_IMGUrl = this.getGr_IMGUrl();
        final Object other$gr_IMGUrl = other.getGr_IMGUrl();
        if (this$gr_IMGUrl == null ? other$gr_IMGUrl != null : !this$gr_IMGUrl.equals(other$gr_IMGUrl))
            return false;
        final Object this$tempBitmap = this.getTempBitmap();
        final Object other$tempBitmap = other.getTempBitmap();
        if (this$tempBitmap == null ? other$tempBitmap != null : !this$tempBitmap.equals(other$tempBitmap))
            return false;
        if (this.getGr_Shade() != other.getGr_Shade()) return false;
        if (this.getGr_Check1() != other.getGr_Check1()) return false;
        if (this.getGr_Check2() != other.getGr_Check2()) return false;
        if (this.getGr_Check3() != other.getGr_Check3()) return false;
        if (this.getGr_Check4() != other.getGr_Check4()) return false;
        if (this.getGr_Check5() != other.getGr_Check5()) return false;
        if (this.getGr_Check6() != other.getGr_Check6()) return false;
        if (this.getGr_Check7() != other.getGr_Check7()) return false;
        if (this.getGr_Check8() != other.getGr_Check8()) return false;
        if (this.getGr_Check9() != other.getGr_Check9()) return false;
        if (this.getGr_Check10() != other.getGr_Check10()) return false;
        final Object this$gr_WriteField = this.getGr_WriteField();
        final Object other$gr_WriteField = other.getGr_WriteField();
        if (this$gr_WriteField == null ? other$gr_WriteField != null : !this$gr_WriteField.equals(other$gr_WriteField))
            return false;
        if (this.getGr_Valid() != other.getGr_Valid()) return false;
        if (this.getGr_Contact() != other.getGr_Contact()) return false;
        if (this.getGr_Bite() != other.getGr_Bite()) return false;
        if (this.getGr_CementType() != other.getGr_CementType()) return false;
        if (this.getGr_ScrewHole() != other.getGr_ScrewHole()) return false;
        final Object this$gr_RequestDateTemp = this.getGr_RequestDateTemp();
        final Object other$gr_RequestDateTemp = other.getGr_RequestDateTemp();
        if (this$gr_RequestDateTemp == null ? other$gr_RequestDateTemp != null : !this$gr_RequestDateTemp.equals(other$gr_RequestDateTemp))
            return false;
        final Object this$gr_CompleteDateTemp = this.getGr_CompleteDateTemp();
        final Object other$gr_CompleteDateTemp = other.getGr_CompleteDateTemp();
        if (this$gr_CompleteDateTemp == null ? other$gr_CompleteDateTemp != null : !this$gr_CompleteDateTemp.equals(other$gr_CompleteDateTemp))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GigongRequestDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getGr_IDX();
        result = result * PRIME + this.getGr_original_IDX();
        result = result * PRIME + this.getGr_hall();
        result = result * PRIME + this.getGr_dr_mb_no();
        final Object $gr_dr_mb_name = this.getGr_dr_mb_name();
        result = result * PRIME + ($gr_dr_mb_name == null ? 43 : $gr_dr_mb_name.hashCode());
        result = result * PRIME + this.getGr_mb_no();
        final Object $gr_mb_name = this.getGr_mb_name();
        result = result * PRIME + ($gr_mb_name == null ? 43 : $gr_mb_name.hashCode());
        result = result * PRIME + this.getGr_gigong_mb_no();
        final Object $gr_gigong_mb_name = this.getGr_gigong_mb_name();
        result = result * PRIME + ($gr_gigong_mb_name == null ? 43 : $gr_gigong_mb_name.hashCode());
        final Object $gr_check_mb_no = this.getGr_check_mb_no();
        result = result * PRIME + ($gr_check_mb_no == null ? 43 : $gr_check_mb_no.hashCode());
        result = result * PRIME + this.getGr_check_mb_name();
        final Object $gr_Name = this.getGr_Name();
        result = result * PRIME + ($gr_Name == null ? 43 : $gr_Name.hashCode());
        final Object $gr_RequestDate = this.getGr_RequestDate();
        result = result * PRIME + ($gr_RequestDate == null ? 43 : $gr_RequestDate.hashCode());
        result = result * PRIME + this.getGr_Gender();
        final Object $gr_ChartID = this.getGr_ChartID();
        result = result * PRIME + ($gr_ChartID == null ? 43 : $gr_ChartID.hashCode());
        final Object $gr_CompleteDate = this.getGr_CompleteDate();
        result = result * PRIME + ($gr_CompleteDate == null ? 43 : $gr_CompleteDate.hashCode());
        final Object $gr_CompleteDateTime = this.getGr_CompleteDateTime();
        result = result * PRIME + ($gr_CompleteDateTime == null ? 43 : $gr_CompleteDateTime.hashCode());
        result = result * PRIME + this.getGr_Complete();
        result = result * PRIME + this.getGr_Type();
        result = result * PRIME + this.getGr_isCheckComplete();
        final Object $gr_IMGUrl = this.getGr_IMGUrl();
        result = result * PRIME + ($gr_IMGUrl == null ? 43 : $gr_IMGUrl.hashCode());
        final Object $tempBitmap = this.getTempBitmap();
        result = result * PRIME + ($tempBitmap == null ? 43 : $tempBitmap.hashCode());
        result = result * PRIME + this.getGr_Shade();
        result = result * PRIME + this.getGr_Check1();
        result = result * PRIME + this.getGr_Check2();
        result = result * PRIME + this.getGr_Check3();
        result = result * PRIME + this.getGr_Check4();
        result = result * PRIME + this.getGr_Check5();
        result = result * PRIME + this.getGr_Check6();
        result = result * PRIME + this.getGr_Check7();
        result = result * PRIME + this.getGr_Check8();
        result = result * PRIME + this.getGr_Check9();
        result = result * PRIME + this.getGr_Check10();
        final Object $gr_WriteField = this.getGr_WriteField();
        result = result * PRIME + ($gr_WriteField == null ? 43 : $gr_WriteField.hashCode());
        result = result * PRIME + this.getGr_Valid();
        result = result * PRIME + this.getGr_Contact();
        result = result * PRIME + this.getGr_Bite();
        result = result * PRIME + this.getGr_CementType();
        result = result * PRIME + this.getGr_ScrewHole();
        final Object $gr_RequestDateTemp = this.getGr_RequestDateTemp();
        result = result * PRIME + ($gr_RequestDateTemp == null ? 43 : $gr_RequestDateTemp.hashCode());
        final Object $gr_CompleteDateTemp = this.getGr_CompleteDateTemp();
        result = result * PRIME + ($gr_CompleteDateTemp == null ? 43 : $gr_CompleteDateTemp.hashCode());
        return result;
    }

    public String toString() {
        return "GigongRequestDTO(gr_IDX=" + this.getGr_IDX() + ", gr_original_IDX=" + this.getGr_original_IDX() + ", gr_hall=" + this.getGr_hall() + ", gr_dr_mb_no=" + this.getGr_dr_mb_no() + ", gr_dr_mb_name=" + this.getGr_dr_mb_name() + ", gr_mb_no=" + this.getGr_mb_no() + ", gr_mb_name=" + this.getGr_mb_name() + ", gr_gigong_mb_no=" + this.getGr_gigong_mb_no() + ", gr_gigong_mb_name=" + this.getGr_gigong_mb_name() + ", gr_check_mb_no=" + this.getGr_check_mb_no() + ", gr_check_mb_name=" + this.getGr_check_mb_name() + ", gr_Name=" + this.getGr_Name() + ", gr_RequestDate=" + this.getGr_RequestDate() + ", gr_Gender=" + this.getGr_Gender() + ", gr_ChartID=" + this.getGr_ChartID() + ", gr_CompleteDate=" + this.getGr_CompleteDate() + ", gr_CompleteDateTime=" + this.getGr_CompleteDateTime() + ", gr_Complete=" + this.getGr_Complete() + ", gr_Type=" + this.getGr_Type() + ", gr_isCheckComplete=" + this.getGr_isCheckComplete() + ", gr_IMGUrl=" + this.getGr_IMGUrl() + ", tempBitmap=" + this.getTempBitmap() + ", gr_Shade=" + this.getGr_Shade() + ", gr_Check1=" + this.getGr_Check1() + ", gr_Check2=" + this.getGr_Check2() + ", gr_Check3=" + this.getGr_Check3() + ", gr_Check4=" + this.getGr_Check4() + ", gr_Check5=" + this.getGr_Check5() + ", gr_Check6=" + this.getGr_Check6() + ", gr_Check7=" + this.getGr_Check7() + ", gr_Check8=" + this.getGr_Check8() + ", gr_Check9=" + this.getGr_Check9() + ", gr_Check10=" + this.getGr_Check10() + ", gr_WriteField=" + this.getGr_WriteField() + ", gr_Valid=" + this.getGr_Valid() + ", gr_Contact=" + this.getGr_Contact() + ", gr_Bite=" + this.getGr_Bite() + ", gr_CementType=" + this.getGr_CementType() + ", gr_ScrewHole=" + this.getGr_ScrewHole() + ", gr_RequestDateTemp=" + this.getGr_RequestDateTemp() + ", gr_CompleteDateTemp=" + this.getGr_CompleteDateTemp() + ")\n";
    }
}
