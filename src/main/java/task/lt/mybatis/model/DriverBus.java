package task.lt.mybatis.model;

public class DriverBus {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRIVER_BUS.BUS_ID
     *
     * @mbg.generated Mon Apr 25 14:30:11 EEST 2022
     */
    private Integer busId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRIVER_BUS.DRIVER_ID
     *
     * @mbg.generated Mon Apr 25 14:30:11 EEST 2022
     */
    private Integer driverId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRIVER_BUS.BUS_ID
     *
     * @return the value of PUBLIC.DRIVER_BUS.BUS_ID
     *
     * @mbg.generated Mon Apr 25 14:30:11 EEST 2022
     */
    public Integer getBusId() {
        return busId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRIVER_BUS.BUS_ID
     *
     * @param busId the value for PUBLIC.DRIVER_BUS.BUS_ID
     *
     * @mbg.generated Mon Apr 25 14:30:11 EEST 2022
     */
    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRIVER_BUS.DRIVER_ID
     *
     * @return the value of PUBLIC.DRIVER_BUS.DRIVER_ID
     *
     * @mbg.generated Mon Apr 25 14:30:11 EEST 2022
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRIVER_BUS.DRIVER_ID
     *
     * @param driverId the value for PUBLIC.DRIVER_BUS.DRIVER_ID
     *
     * @mbg.generated Mon Apr 25 14:30:11 EEST 2022
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}