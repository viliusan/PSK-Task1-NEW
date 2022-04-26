package task.lt.mybatis.model;

public class Ticket {
    private Flight assignedFlight;

    public Flight getAssignedFlight() {
        return assignedFlight;
    }

    public void setAssignedFlight(Flight assignedFlight) {
        this.assignedFlight = assignedFlight;
    }
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TICKET.ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TICKET.IS_BOUGHT
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Boolean isBought;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TICKET.PRICE
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TICKET.SEAT
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Integer seat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TICKET.TICKET_NUMBER
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Integer ticketNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TICKET.OPT_LOCK_VERSION
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Integer optLockVersion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TICKET.FLIGHT_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Integer flightId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TICKET.ID
     *
     * @return the value of PUBLIC.TICKET.ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TICKET.ID
     *
     * @param id the value for PUBLIC.TICKET.ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TICKET.IS_BOUGHT
     *
     * @return the value of PUBLIC.TICKET.IS_BOUGHT
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Boolean getIsBought() {
        return isBought;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TICKET.IS_BOUGHT
     *
     * @param isBought the value for PUBLIC.TICKET.IS_BOUGHT
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setIsBought(Boolean isBought) {
        this.isBought = isBought;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TICKET.PRICE
     *
     * @return the value of PUBLIC.TICKET.PRICE
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TICKET.PRICE
     *
     * @param price the value for PUBLIC.TICKET.PRICE
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TICKET.SEAT
     *
     * @return the value of PUBLIC.TICKET.SEAT
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Integer getSeat() {
        return seat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TICKET.SEAT
     *
     * @param seat the value for PUBLIC.TICKET.SEAT
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TICKET.TICKET_NUMBER
     *
     * @return the value of PUBLIC.TICKET.TICKET_NUMBER
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Integer getTicketNumber() {
        return ticketNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TICKET.TICKET_NUMBER
     *
     * @param ticketNumber the value for PUBLIC.TICKET.TICKET_NUMBER
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TICKET.OPT_LOCK_VERSION
     *
     * @return the value of PUBLIC.TICKET.OPT_LOCK_VERSION
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TICKET.OPT_LOCK_VERSION
     *
     * @param optLockVersion the value for PUBLIC.TICKET.OPT_LOCK_VERSION
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TICKET.FLIGHT_ID
     *
     * @return the value of PUBLIC.TICKET.FLIGHT_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Integer getFlightId() {
        return flightId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TICKET.FLIGHT_ID
     *
     * @param flightId the value for PUBLIC.TICKET.FLIGHT_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
}