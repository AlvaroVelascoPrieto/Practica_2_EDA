package org.eda.packlaboratorio2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

		Node<T> nuevo = new Node<T>(elem);
		if (this.isEmpty()){
			this.last=nuevo;
			this.last.next=this.last;
			this.last.prev=this.last;
		}
		else{
			nuevo.next = this.last.next;
			this.last.next.prev = nuevo;
			nuevo.prev=this.last;
			this.last.next=nuevo;
		}
		this.count=this.count +1;
	}

	public void addToRear(T elem) {
	// a�ade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo = new Node<T>(elem);
		if (this.isEmpty()){
			this.last=nuevo;
			this.last.next=this.last;
			this.last.prev=this.last;
		}
		else{
			nuevo.prev = this.last;
			nuevo.next = this.last.next;
			this.last.next.prev=nuevo;
			this.last.next=nuevo;
			this.last=nuevo;
		}
		this.count=this.count +1;
	}
	
	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!
		if (this.contains(target)){
			if(this.last.data==target) {
				addToRear(elem);
			}
			else {
				Node<T> nuevo = new Node<T>(elem);
				boolean enc = false;
				Node<T> aux = this.last.next;
				while(!enc && aux!=this.last){
					if (aux.data==target) {
						enc=true;
						nuevo.next=aux.next;
						nuevo.prev=aux;
						aux.next.prev=nuevo;
						aux.next=nuevo;
					}
					aux=aux.next;
				}
				this.count=this.count +1;
			}
		}
	}

}
