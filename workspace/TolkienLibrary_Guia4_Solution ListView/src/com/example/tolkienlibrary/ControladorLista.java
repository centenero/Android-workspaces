package com.example.tolkienlibrary;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ControladorLista extends ListActivity {

	public class Libro {
		private String Titulo = "";
		private String Autor = "";

		public String getTitulo() {
			return Titulo;
		}

		public String getAutor() {
			return Autor;
		}

		public void setTitulo(String titulo) {
			Titulo = titulo;
		}

		public void setAutor(String autor) {
			Autor = autor;
		}
	}

	private class LibroAdapter extends ArrayAdapter<Libro> {

		private ArrayList<Libro> items;

		public LibroAdapter(Context context, int textViewResourceId, ArrayList<Libro> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.lista_item, null);
			}
			Libro libro = items.get(position);
			if (libro != null) {
				TextView ttitulo = (TextView) v.findViewById(R.id.titulo);
				TextView tautor = (TextView) v.findViewById(R.id.autor);
				if (ttitulo != null) {
					ttitulo.setText(libro.getTitulo());
				}
				if (tautor != null) {
					tautor.setText(libro.getAutor());
				}
			}
			return v;
		}
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Obtenemos la lista de Libros
		ArrayList<Libro> Libros = getItems();
		// Entregamos la lista de Libros al adaptador de la lista en el Layout Lista.xml
		setListAdapter(new LibroAdapter(this, R.layout.lista_item, Libros));
	}

	/*
	 * Obtiene una lista de libros
	 * 
	 * @returns ArrayList<Libro> libros
	 */
	public ArrayList<Libro> getItems() {
		ArrayList<Libro> MiLista = new ArrayList<Libro>();

		// Creamos los objetos Libro
		Libro libro1 = new Libro();
		libro1.setTitulo("El Silmarillion");
		libro1.setAutor("J.R.R. Tolkien");

		Libro libro2 = new Libro();
		libro2.setTitulo("El Se–or de los Anillos");
		libro2.setAutor("J.R.R. Tolkien");

		Libro libro3 = new Libro();
		libro3.setTitulo("Los propios dioses");
		libro3.setAutor("Isaac Asimov");

		// A–adimos los libros a la lista
		MiLista.add(libro1);
		MiLista.add(libro2);
		MiLista.add(libro3);
		
		int i= 0;
		Libro libro10;
		while (i < 20) {
			libro10 = new Libro();
			libro10.setTitulo("Titulo" + i);
			libro10.setAutor("Autor" + i);
			MiLista.add(libro10);
			i++;
		}

		return MiLista;
	}
}