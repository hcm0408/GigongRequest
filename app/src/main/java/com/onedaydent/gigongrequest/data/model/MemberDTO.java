package com.onedaydent.gigongrequest.data.model;

public class MemberDTO {

    private static String TAG = MemberDTO.class.getSimpleName();
    private int mb_no;
    private String mb_name;
    private int mb_hall;
    private String mb_department;

    public MemberDTO() {
    }

    public MemberDTO(int mb_no, String mb_name, int mb_hall, String mb_department) {
        this.mb_no = mb_no;
        this.mb_name = mb_name;
        this.mb_hall = mb_hall;
        this.mb_department = mb_department;
    }

    public int getMb_no() {
        return this.mb_no;
    }

    public String getMb_name() {
        return this.mb_name;
    }

    public int getMb_hall() {
        return this.mb_hall;
    }

    public String getMb_department() {
        return this.mb_department;
    }

    public void setMb_no(int mb_no) {
        this.mb_no = mb_no;
    }

    public void setMb_name(String mb_name) {
        this.mb_name = mb_name;
    }

    public void setMb_hall(int mb_hall) {
        this.mb_hall = mb_hall;
    }

    public void setMb_department(String mb_department) {
        this.mb_department = mb_department;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MemberDTO)) return false;
        final MemberDTO other = (MemberDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getMb_no() != other.getMb_no()) return false;
        final Object this$mb_name = this.getMb_name();
        final Object other$mb_name = other.getMb_name();
        if (this$mb_name == null ? other$mb_name != null : !this$mb_name.equals(other$mb_name))
            return false;
        if (this.getMb_hall() != other.getMb_hall()) return false;
        final Object this$mb_department = this.getMb_department();
        final Object other$mb_department = other.getMb_department();
        if (this$mb_department == null ? other$mb_department != null : !this$mb_department.equals(other$mb_department))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MemberDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getMb_no();
        final Object $mb_name = this.getMb_name();
        result = result * PRIME + ($mb_name == null ? 43 : $mb_name.hashCode());
        result = result * PRIME + this.getMb_hall();
        final Object $mb_department = this.getMb_department();
        result = result * PRIME + ($mb_department == null ? 43 : $mb_department.hashCode());
        return result;
    }

    public String toString() {
        return "MemberDTO(mb_no=" + this.getMb_no() + ", mb_name=" + this.getMb_name() + ", mb_hall=" + this.getMb_hall() + ", mb_department=" + this.getMb_department() + ")";
    }
}