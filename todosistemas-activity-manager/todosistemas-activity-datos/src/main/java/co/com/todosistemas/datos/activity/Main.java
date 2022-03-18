package co.com.todosistemas.datos.activity;
public class Main {

	public static void main(String[] args) {
		System.out
				.println("Hi there! I was forged as part of the project you call todosistemas-activity-datos.");
		Main m=new Main();
		try {
			m.validarVacio("mafe","","fecha");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean validarVacio(Object ... datos) throws Exception{
		if(datos.length==3) {
		for (int i=0;i<datos.length;i++) {
			if(i!=4&&i!=6) {
				if(datos[i] != null&&!datos[i].toString().isEmpty()) {
					continue;
				}else {
					throw new Exception("el dato solicitado en pantalla ubicado de "+i+ " es nulo por favor llenarlo");
				}
			}
		}
		return true;
	}else {
		throw new Exception("no se ha enviado la cantidad minima de datos solicitados para realizar la insercion");

	}
	}
	
	
}