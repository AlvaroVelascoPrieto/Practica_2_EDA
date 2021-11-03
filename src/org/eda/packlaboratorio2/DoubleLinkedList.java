package org.eda.packlaboratorio2;
import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
		last = null;
		descr = "";
		count = 0;
	}

	public void setDescr(String nom) {
		descr = nom;
	}

	public String getDescr() {
		return descr;
	}

	public T removeFirst() {
		// Elimina el primer elemento de la lista
		// Precondici�n:
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T devolver;
		if (last==null){
			return null;
		}
		else if (last.next==last){
			devolver = last.data;
			last = null;
		}
		else{
			devolver = last.next.data;
			last.next.next.prev = last;
			last.next = last.next.next;
		}
		this.count=this.count-1;
		return devolver;
	}

	public T removeLast() {
		// Elimina el �ltimo elemento de la lista
		// Precondici�n:
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T devolver;
		if (last==null){
			return null;
		}
		else if (last.next==last){
			devolver = last.data;
			last =null;
		}
		else{
			devolver=last.data;
			last.prev.next=last.next;
			last.next.prev=last.prev;
			last=last.prev;
		}
		this.count=this.count-1;
		return devolver;
	}


	public T remove(T elem) {
		//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		//Coste n cuidado
		Node<T> current;
		if (last==null){
			return null;
		}
		if (last.data==elem){
			return this.removeLast();
		}
		else {
			current = last.next;
			while (last.data!=current.data){
				if (current.data==elem){
					current.next.prev=current.prev;
					current.prev.next=current.next;
					return current.data;
				}
				else{
					current=current.next;
				}
			}
		}
		this.count=this.count-1;
		return current.data;
	}

	public T first() {
		//Da acceso al primer elemento de la lista
		if (isEmpty()){
			return null;}
		else {return last.next.data;}
	}

	public T last() {
		//Da acceso al �ltimo elemento de la lista
		if (isEmpty()) {
			return null;
		}
		else {return last.data;}
	}

	public boolean contains(T elem) {
		//Determina si la lista contiene un elemento concreto
		if (isEmpty())
			return false;
		else {
			Node<T> act = this.last;
			if (act.data.equals(elem)){
				return true;
			}
			while (act.prev!=null) {
				act=act.prev;
				if (act.data.equals(elem)) {
					return true;
				}
			}
		}
		return false;
	}

	public T find(T elem) {
		//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if (this.isEmpty())
			return (null);
		else {
			Node<T> act = this.last;
			while (act.prev!=last) {
				if (act.data.equals(elem)) {
					return act.data;
				}
				act=act.prev;
			}
		}
		return null;
	}

	public boolean isEmpty()
	//Determina si la lista est� vac�a
	{ return last == null;};

	public int size()
	//Determina el n�mero de elementos de la lista
	{ return count;};

	/** Return an iterator to the stack that iterates through the items . */
	public Iterator<T> iterator() { return new ListIterator(); }

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator implements Iterator<T> {

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		private Node<T> aux=last.next;
		private boolean ult=false;

		@Override
		public boolean hasNext() {
			if(aux!=last && !ult) {
				return true;
			}
			else if (!ult) {
				ult=true;
				return true;
			}
			else {return false;}
		}

		public T next(){
			T a = aux.data;
			aux = aux.next;
			return a;
		}


	} // private class


	public void visualizarNodos() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T elem = it.next();
			result = result + "[" + elem.toString() + "] \n";
		}
		return "DoubleLinkedList " + result + "]";
	}

}
