package com.onedaydent.gigongrequest.data.model;

public class PatientDTO {
    private static String TAG = PatientDTO.class.getSimpleName();
    private String Name;
    private String Gender;
    private String ChartID;

    public PatientDTO() {
    }

    public String getName() {
        return this.Name;
    }

    public String getGender() {
        return this.Gender;
    }

    public String getChartID() {
        return this.ChartID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setChartID(String ChartID) {
        this.ChartID = ChartID;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PatientDTO)) return false;
        final PatientDTO other = (PatientDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$Name = this.getName();
        final Object other$Name = other.getName();
        if (this$Name == null ? other$Name != null : !this$Name.equals(other$Name)) return false;
        final Object this$Gender = this.getGender();
        final Object other$Gender = other.getGender();
        if (this$Gender == null ? other$Gender != null : !this$Gender.equals(other$Gender))
            return false;
        final Object this$ChartID = this.getChartID();
        final Object other$ChartID = other.getChartID();
        if (this$ChartID == null ? other$ChartID != null : !this$ChartID.equals(other$ChartID))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PatientDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $Name = this.getName();
        result = result * PRIME + ($Name == null ? 43 : $Name.hashCode());
        final Object $Gender = this.getGender();
        result = result * PRIME + ($Gender == null ? 43 : $Gender.hashCode());
        final Object $ChartID = this.getChartID();
        result = result * PRIME + ($ChartID == null ? 43 : $ChartID.hashCode());
        return result;
    }

    public String toString() {
        return "PatientDTO(Name=" + this.getName() + ", Gender=" + this.getGender() + ", ChartID=" + this.getChartID() + ")";
    }
}
