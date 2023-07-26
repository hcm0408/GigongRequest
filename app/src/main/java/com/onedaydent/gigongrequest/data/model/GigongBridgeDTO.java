package com.onedaydent.gigongrequest.data.model;

public class GigongBridgeDTO {
    private int gb_IDX; 		// 인덱스
    private int gb_gr_IDX;		// 기공물 번호
    private int gb_Point; 		// 브릿지 번호

    public GigongBridgeDTO() {
    }

    public int getGb_IDX() {
        return this.gb_IDX;
    }

    public int getGb_gr_IDX() {
        return this.gb_gr_IDX;
    }

    public int getGb_Point() {
        return this.gb_Point;
    }

    public void setGb_IDX(int gb_IDX) {
        this.gb_IDX = gb_IDX;
    }

    public void setGb_gr_IDX(int gb_gr_IDX) {
        this.gb_gr_IDX = gb_gr_IDX;
    }

    public void setGb_Point(int gb_Point) {
        this.gb_Point = gb_Point;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GigongBridgeDTO)) return false;
        final GigongBridgeDTO other = (GigongBridgeDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getGb_IDX() != other.getGb_IDX()) return false;
        if (this.getGb_gr_IDX() != other.getGb_gr_IDX()) return false;
        if (this.getGb_Point() != other.getGb_Point()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GigongBridgeDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getGb_IDX();
        result = result * PRIME + this.getGb_gr_IDX();
        result = result * PRIME + this.getGb_Point();
        return result;
    }

    public String toString() {
        return "GigongBridgeDTO(gb_IDX=" + this.getGb_IDX() + ", gb_gr_IDX=" + this.getGb_gr_IDX() + ", gb_Point=" + this.getGb_Point() + ")";
    }
}
