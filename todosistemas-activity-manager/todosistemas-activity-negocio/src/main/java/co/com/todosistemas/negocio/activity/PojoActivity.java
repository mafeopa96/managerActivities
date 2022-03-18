package co.com.todosistemas.negocio.activity;
/**
 * clase que representa la respuesta del combo
 * @author mochoa
 *
 */
public class PojoRespComMecanico {

	String name;
    Integer state;
	Date estimatedDate;
    Integer employee;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the estimatedDate
	 */
	public String getEstimatedDate() {
		return estimatedDate;
	}
	/**
	 * @param estimatedDate the estimatedDate to set
	 */
	public void setEstimatedDate(String estimatedDate) {
		this.estimatedDate = estimatedDate;
	}
    /**
	 * @return the employee
	 */
	public Integer getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Integer employee) {
		this.employee = employee;
	}
}
