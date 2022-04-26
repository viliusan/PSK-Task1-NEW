package task.lt.mybatis.model;

import java.util.List;

public class Flight {
    private Pilot assignedPilot;
    private Plane assignedPlane;
    private List<Ticket> tickets;

    public Pilot getAssignedPilot() {
        return assignedPilot;
    }

    public void setAssignedPilot(Pilot assignedPilot) {
        this.assignedPilot = assignedPilot;
    }

    public Plane getAssignedPlane() {
        return assignedPlane;
    }

    public void setAssignedPlane(Plane assignedPlane) {
        this.assignedPlane = assignedPlane;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.FLIGHT.ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.FLIGHT.ARRIVAL_TIME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private String arrivalTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.FLIGHT.DEPARTURE_TIME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private String departureTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.FLIGHT.NAME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.FLIGHT.PILOT_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Integer pilotId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.FLIGHT.PLANE_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    private Integer planeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.FLIGHT.ID
     *
     * @return the value of PUBLIC.FLIGHT.ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.FLIGHT.ID
     *
     * @param id the value for PUBLIC.FLIGHT.ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.FLIGHT.ARRIVAL_TIME
     *
     * @return the value of PUBLIC.FLIGHT.ARRIVAL_TIME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.FLIGHT.ARRIVAL_TIME
     *
     * @param arrivalTime the value for PUBLIC.FLIGHT.ARRIVAL_TIME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.FLIGHT.DEPARTURE_TIME
     *
     * @return the value of PUBLIC.FLIGHT.DEPARTURE_TIME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.FLIGHT.DEPARTURE_TIME
     *
     * @param departureTime the value for PUBLIC.FLIGHT.DEPARTURE_TIME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.FLIGHT.NAME
     *
     * @return the value of PUBLIC.FLIGHT.NAME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.FLIGHT.NAME
     *
     * @param name the value for PUBLIC.FLIGHT.NAME
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.FLIGHT.PILOT_ID
     *
     * @return the value of PUBLIC.FLIGHT.PILOT_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Integer getPilotId() {
        return pilotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.FLIGHT.PILOT_ID
     *
     * @param pilotId the value for PUBLIC.FLIGHT.PILOT_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setPilotId(Integer pilotId) {
        this.pilotId = pilotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.FLIGHT.PLANE_ID
     *
     * @return the value of PUBLIC.FLIGHT.PLANE_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public Integer getPlaneId() {
        return planeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.FLIGHT.PLANE_ID
     *
     * @param planeId the value for PUBLIC.FLIGHT.PLANE_ID
     *
     * @mbg.generated Tue Apr 26 09:44:11 EEST 2022
     */
    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }
}