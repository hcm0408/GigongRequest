package com.onedaydent.gigongrequest.data.model;

import java.util.Date;

public class GigongStep1DTO {
    private static String TAG = GigongStep1DTO.class.getSimpleName();
    /* 기본정보 */
    private int st1_IDX;				    // 인덱스
    private int st1_hall;					// 관
    private String gr_Name;					// 환자성함
    private Date gr_RequestDate;			// 접수일
    private int gr_Gender;					// 성별 0 = 남자, 1 = 여자
    private String gr_ChartID;				// 차트번호
    private int st1_dr_mb_no; 				// Dr no
    private String st1_dr_mb_name;			// Dr 이름
    private int st1_mb_no; 					// 위생사 no
    private String st1_mb_name;				// 위생사 이름
    private int st1_gigong_mb_no;			// 기공사 no
    private String st1_gigong_mb_name;		// 기공사 이름
    private String st1_check_mb_no;			// 팀장 no
    private int st1_check_mb_name;			// 팀장 이름
    private Date gr_CompleteDate;			// 완성일
    private String gr_CompleteDateTime;		// 완성일 시간
    private int gr_Complete;				// 0 = 작성, 1 = 확인, 2 = 완성
    private int gr_Type;					// 0 = 일반, 1 = 당일, 2 = 1박2일
    private int gr_isCheckComplete;         // 기공물 담당자 확인 0 미확인 1확인
    private String gr_RequestDateTemp;
    private String gr_CompleteDateTemp;

    public GigongStep1DTO() {
    }

    public int getSt1_IDX() {
        return this.st1_IDX;
    }

    public int getSt1_hall() {
        return this.st1_hall;
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

    public int getSt1_dr_mb_no() {
        return this.st1_dr_mb_no;
    }

    public String getSt1_dr_mb_name() {
        return this.st1_dr_mb_name;
    }

    public int getSt1_mb_no() {
        return this.st1_mb_no;
    }

    public String getSt1_mb_name() {
        return this.st1_mb_name;
    }

    public int getSt1_gigong_mb_no() {
        return this.st1_gigong_mb_no;
    }

    public String getSt1_gigong_mb_name() {
        return this.st1_gigong_mb_name;
    }

    public String getSt1_check_mb_no() {
        return this.st1_check_mb_no;
    }

    public int getSt1_check_mb_name() {
        return this.st1_check_mb_name;
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

    public String getGr_RequestDateTemp() {
        return this.gr_RequestDateTemp;
    }

    public String getGr_CompleteDateTemp() {
        return this.gr_CompleteDateTemp;
    }

    public void setSt1_IDX(int st1_IDX) {
        this.st1_IDX = st1_IDX;
    }

    public void setSt1_hall(int st1_hall) {
        this.st1_hall = st1_hall;
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

    public void setSt1_dr_mb_no(int st1_dr_mb_no) {
        this.st1_dr_mb_no = st1_dr_mb_no;
    }

    public void setSt1_dr_mb_name(String st1_dr_mb_name) {
        this.st1_dr_mb_name = st1_dr_mb_name;
    }

    public void setSt1_mb_no(int st1_mb_no) {
        this.st1_mb_no = st1_mb_no;
    }

    public void setSt1_mb_name(String st1_mb_name) {
        this.st1_mb_name = st1_mb_name;
    }

    public void setSt1_gigong_mb_no(int st1_gigong_mb_no) {
        this.st1_gigong_mb_no = st1_gigong_mb_no;
    }

    public void setSt1_gigong_mb_name(String st1_gigong_mb_name) {
        this.st1_gigong_mb_name = st1_gigong_mb_name;
    }

    public void setSt1_check_mb_no(String st1_check_mb_no) {
        this.st1_check_mb_no = st1_check_mb_no;
    }

    public void setSt1_check_mb_name(int st1_check_mb_name) {
        this.st1_check_mb_name = st1_check_mb_name;
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

    public void setGr_RequestDateTemp(String gr_RequestDateTemp) {
        this.gr_RequestDateTemp = gr_RequestDateTemp;
    }

    public void setGr_CompleteDateTemp(String gr_CompleteDateTemp) {
        this.gr_CompleteDateTemp = gr_CompleteDateTemp;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GigongStep1DTO)) return false;
        final GigongStep1DTO other = (GigongStep1DTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getSt1_IDX() != other.getSt1_IDX()) return false;
        if (this.getSt1_hall() != other.getSt1_hall()) return false;
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
        if (this.getSt1_dr_mb_no() != other.getSt1_dr_mb_no()) return false;
        final Object this$st1_dr_mb_name = this.getSt1_dr_mb_name();
        final Object other$st1_dr_mb_name = other.getSt1_dr_mb_name();
        if (this$st1_dr_mb_name == null ? other$st1_dr_mb_name != null : !this$st1_dr_mb_name.equals(other$st1_dr_mb_name))
            return false;
        if (this.getSt1_mb_no() != other.getSt1_mb_no()) return false;
        final Object this$st1_mb_name = this.getSt1_mb_name();
        final Object other$st1_mb_name = other.getSt1_mb_name();
        if (this$st1_mb_name == null ? other$st1_mb_name != null : !this$st1_mb_name.equals(other$st1_mb_name))
            return false;
        if (this.getSt1_gigong_mb_no() != other.getSt1_gigong_mb_no()) return false;
        final Object this$st1_gigong_mb_name = this.getSt1_gigong_mb_name();
        final Object other$st1_gigong_mb_name = other.getSt1_gigong_mb_name();
        if (this$st1_gigong_mb_name == null ? other$st1_gigong_mb_name != null : !this$st1_gigong_mb_name.equals(other$st1_gigong_mb_name))
            return false;
        final Object this$st1_check_mb_no = this.getSt1_check_mb_no();
        final Object other$st1_check_mb_no = other.getSt1_check_mb_no();
        if (this$st1_check_mb_no == null ? other$st1_check_mb_no != null : !this$st1_check_mb_no.equals(other$st1_check_mb_no))
            return false;
        if (this.getSt1_check_mb_name() != other.getSt1_check_mb_name()) return false;
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
        return other instanceof GigongStep1DTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getSt1_IDX();
        result = result * PRIME + this.getSt1_hall();
        final Object $gr_Name = this.getGr_Name();
        result = result * PRIME + ($gr_Name == null ? 43 : $gr_Name.hashCode());
        final Object $gr_RequestDate = this.getGr_RequestDate();
        result = result * PRIME + ($gr_RequestDate == null ? 43 : $gr_RequestDate.hashCode());
        result = result * PRIME + this.getGr_Gender();
        final Object $gr_ChartID = this.getGr_ChartID();
        result = result * PRIME + ($gr_ChartID == null ? 43 : $gr_ChartID.hashCode());
        result = result * PRIME + this.getSt1_dr_mb_no();
        final Object $st1_dr_mb_name = this.getSt1_dr_mb_name();
        result = result * PRIME + ($st1_dr_mb_name == null ? 43 : $st1_dr_mb_name.hashCode());
        result = result * PRIME + this.getSt1_mb_no();
        final Object $st1_mb_name = this.getSt1_mb_name();
        result = result * PRIME + ($st1_mb_name == null ? 43 : $st1_mb_name.hashCode());
        result = result * PRIME + this.getSt1_gigong_mb_no();
        final Object $st1_gigong_mb_name = this.getSt1_gigong_mb_name();
        result = result * PRIME + ($st1_gigong_mb_name == null ? 43 : $st1_gigong_mb_name.hashCode());
        final Object $st1_check_mb_no = this.getSt1_check_mb_no();
        result = result * PRIME + ($st1_check_mb_no == null ? 43 : $st1_check_mb_no.hashCode());
        result = result * PRIME + this.getSt1_check_mb_name();
        final Object $gr_CompleteDate = this.getGr_CompleteDate();
        result = result * PRIME + ($gr_CompleteDate == null ? 43 : $gr_CompleteDate.hashCode());
        final Object $gr_CompleteDateTime = this.getGr_CompleteDateTime();
        result = result * PRIME + ($gr_CompleteDateTime == null ? 43 : $gr_CompleteDateTime.hashCode());
        result = result * PRIME + this.getGr_Complete();
        result = result * PRIME + this.getGr_Type();
        result = result * PRIME + this.getGr_isCheckComplete();
        final Object $gr_RequestDateTemp = this.getGr_RequestDateTemp();
        result = result * PRIME + ($gr_RequestDateTemp == null ? 43 : $gr_RequestDateTemp.hashCode());
        final Object $gr_CompleteDateTemp = this.getGr_CompleteDateTemp();
        result = result * PRIME + ($gr_CompleteDateTemp == null ? 43 : $gr_CompleteDateTemp.hashCode());
        return result;
    }

    public String toString() {
        return "GigongStep1DTO(st1_IDX=" + this.getSt1_IDX() + ", st1_hall=" + this.getSt1_hall() + ", gr_Name=" + this.getGr_Name() + ", gr_RequestDate=" + this.getGr_RequestDate() + ", gr_Gender=" + this.getGr_Gender() + ", gr_ChartID=" + this.getGr_ChartID() + ", st1_dr_mb_no=" + this.getSt1_dr_mb_no() + ", st1_dr_mb_name=" + this.getSt1_dr_mb_name() + ", st1_mb_no=" + this.getSt1_mb_no() + ", st1_mb_name=" + this.getSt1_mb_name() + ", st1_gigong_mb_no=" + this.getSt1_gigong_mb_no() + ", st1_gigong_mb_name=" + this.getSt1_gigong_mb_name() + ", st1_check_mb_no=" + this.getSt1_check_mb_no() + ", st1_check_mb_name=" + this.getSt1_check_mb_name() + ", gr_CompleteDate=" + this.getGr_CompleteDate() + ", gr_CompleteDateTime=" + this.getGr_CompleteDateTime() + ", gr_Complete=" + this.getGr_Complete() + ", gr_Type=" + this.getGr_Type() + ", gr_isCheckComplete=" + this.getGr_isCheckComplete() + ", gr_RequestDateTemp=" + this.getGr_RequestDateTemp() + ", gr_CompleteDateTemp=" + this.getGr_CompleteDateTemp() + ")\n";
    }
}
