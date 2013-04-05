package mi.paquete;

import android.os.Parcel;
import android.os.Parcelable;

public class Pregunta implements Parcelable {

	private String pregunta;
	private String respuesta;
	private String categoria;
	
	
	public Pregunta(String pregunta, String respuesta, String categoria) {
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.categoria = categoria;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void writeToParcel(Parcel dest, int arg1) {
//	
//			int size = this.size();
//			dest.writeInt(size);
//			for (int i = 0; i < size; i++)
//			{
//			Pregunta p = this.get(i);
//			dest.writeString(oLibro.getTitulo());
//			dest.writeString(oLibro.getAutor());
//			dest.writeString(oLibro.getImagen());
//			}
	}
		
	
	
	
}
