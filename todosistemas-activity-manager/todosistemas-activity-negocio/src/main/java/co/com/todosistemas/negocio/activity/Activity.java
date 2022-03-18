package co.com.todosistemas.negocio.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.UserTransaction;
import co.com.todosistemas.activity.PojoEmployee;
import co.com.todosistemas.activity.PojoState;
import com.co.todosistemas.datos.activity.Employee;
import com.co.todosistemas.datos.activity.State;
import co.com.todosistemas.activity.PojoActivity;
import com.co.todosistemas.datos.activity.Activity;



@Named 
public class Mecanico {
	
	
	/**
	 * Transacción JTA
	 */
	@Inject
	UserTransaction ut;
	
	/**
	 * Entidad de persistencia inyectada
	 */
	@PersistenceContext(unitName = "todosistemas-activity-persistence-unit")
	private EntityManager manejadorEntidad;
	
	**
	 * Metodo que permite insertar nuevos mecanicos en la bd mediante la ejecucion de un procedimiento en PL/SQL
	 * 
	 * @return Boolean segun la realizacion exitosa o no del procedimiento
	 * @throws Exception 
	 */
	public int newActivity( Object... parametros) throws Exception {
		validarVacio(parametros);
			try {
				ut.begin();
				manejadorEntidad.joinTransaction();
				manejadorEntidad.save(parametros)
				ut.commit();
				System.out.print("save activity"+ o);
				return o;
			} catch (Exception ebd) {
						ebd.getCause());
				try {
					ut.rollback();
				} catch (Exception e) {
					System.out.print("Se esperaba hacer roolback pero fallo ");
				}
				throw new Exception(ebd.getCause());
			}		
	}

	public int updateActivity( Object... parametros) throws Exception {
		validarVacio(parametros);
			try {
				ut.begin();
				manejadorEntidad.joinTransaction();
				manejadorEntidad.update(parametros)
				ut.commit();
				System.out.print("update activity"+ o);
				return o;
			} catch (Exception ebd) {
						ebd.getCause());
				try {
					ut.rollback();
				} catch (Exception e) {
					System.out.print("Se esperaba hacer roolback pero fallo ");
				}
				throw new Exception(ebd.getCause());
			}		
	}
	public int deleteActivity( int parametro) throws Exception {
		
			try {
				ut.begin();
				manejadorEntidad.joinTransaction();
				manejadorEntidad.deleteById(parametro)
				ut.commit();
				System.out.print("delete activity"+ o);
				return o;
			} catch (Exception ebd) {
						ebd.getCause());
				try {
					ut.rollback();
				} catch (Exception e) {
					System.out.print("Se esperaba hacer roolback pero fallo ");
				}
				throw new Exception(ebd.getCause());
			}		
	}
	private int getActivities() throws BussinessException {
       try {
            List<PojoActivity> activityLoad = new ArrayList<>();
            List<Activity> actividadEntities = Activity.findAll();
            if (!actividadEntities.isEmpty()) {
                for (Activity activity : actividadEntities) {
                    State state = this.getEstado(activity.getEstado());
                    Employee empleadeeE = this.getEmpleado(activity.getIdEmployee());
                    activityLoad.add(
                            new PojoActivity(
                                    activity.getId(),
                                    activity.getName(),
                                    state.getId(),
                                    state.getName(),
                                    activity.estimatedDate(),
                                    empleadeeE.getId(),
                                    empleadeeE.getName(),
                                    this.getDiasRetraso(activity.estimatedDate())
                            ));
                }
            }
            return activityLoad;
        } catch (Exception e) {
			throw new Exception(e.getCause());   
		}	     
    }
		
	private int getEstado(Long idEstado) throws BussinessException {
        try {
            return manejadorEntidad.findById(idEstado).orElseThrow(() -> new BussinessException(""));
        } catch (Exception e) {
           throw new Exception(ebd.getCause());
        }
    }

    private int getEmpleado(Long idEmpleado) throws BussinessException {
        try {
            return empleadosRepository.findById(idEmpleado).orElseThrow(() -> new BussinessException(""));
        } catch (Exception e) {
            throw new Exception(ebd.getCause());
        }
    }
	/**
	 * metodo para validar datos vacios no va a tener en cuenta parametro 4 y 6 debido a que en estos almacena segundo nombre y segundo apellido
	 * @param datos
	 * @return
	 */
	public boolean validarVacio(Object ... datos) throws Exception{
		if(datos.length==3) {
		for (int i=0;i<datos.length;i++) {			
				if(datos[i] != null&&!datos[i].toString().isEmpty()) {
					continue;
				}else {
					throw new Exception("el dato solicitado en pantalla ubicado de "+i+ " es nulo por favor llenarlo");
				}			
		}
		return true;
	}else {
		throw new Exception("no se ha enviado la cantidad minima de datos solicitados para realizar la insercion");

	}
	}

	 private Long getDiasRetraso(Date fechaEstimada) {
        int milisecondsByDay = 86400000;
        long diasRetraso = ((new Date().getTime() - fechaEstimada.getTime()) / milisecondsByDay);
        return diasRetraso >= 0 ? diasRetraso : 0;
    }


	@Override
    public List<PojoEmployee> getEmployees() throws BussinessException {
        List<PojoEmployee> listaParametros = new ArrayList<>();
        List<Employee> employeeEntity = manejadorEntidad.findAll();
        if (employeeEntity.isEmpty())
		throw new Exception("no se han encontrado empleados");

        for (Employee employee : employeeEntity) {
            listaParametros.add(new ParametrosDto(estados.getId(), estados.getNombre()));
        }
        return listaParametros;
    }

    @Override
    public List<PojoState> getStates() throws BussinessException {
        List<PojoState> listaParametros = new ArrayList<>();
        List<State> stateEntities = manejadorEntidad.findAll();
        if (empleadosEntities.isEmpty())
		throw new Exception("no se ha encontrado estados");

        for (State state : stateEntities) {
            listaParametros.add(new ParametrosDto(state.getId(), state.getNombre()));
        }
        return listaParametros;
    }

	
}
