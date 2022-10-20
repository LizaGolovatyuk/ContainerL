package org.example;

/**
 * Класс ListNumber - это контэйнер элементов, реализованный на основе однонаправленного списка
 */
public class ListNumber<T> {

        private Numbers <T> head;
        private int size;

        /**
         * Метод isEmpty провреряет на пустоту контэйнер
         * @return true в случае, если head равен null и false в ином случае
         */
        private boolean isEmpty() {
            return head == null;
        }

    /**
     *  Конструктор без параметров ListNumber
     */
    public ListNumber () {
        head = null;
        size = 0;
    }

    /**
         * Метод findBeforePlace находит указатель на эелемент перед заданным
         * @param pN - указатель на элемент, с которого просиходит поиск
         * @param place_elem - место в списке заданного элемента, начиная с 1
         * @return p - указатель на необходимый элемент
         */
        private Numbers <T> findBeforePlace(Numbers <T> pN, int place_elem) {
            Numbers<T> p1 = null;
            Numbers<T> p2 = pN;
            int place_find = 1;
            if(place_elem<=size+1 && place_elem!=1) {
                while (p2.next != null && place_find < place_elem) {
                    place_find++;
                    p1 = p2;
                    p2 = p2.next;
                }
                if (p2.next == null && place_find != place_elem) p1=p2;
            }
            return p1;
        }

        /**
         * Метод addToHead добавляет элемент в голову списка
         * @param x_ - добавляемый в список элемент
         */
        private void addToHead(T x_) {
            Numbers<T> p = new Numbers(x_);
            p.x = x_;
            p.next = head;
            head = p;
        }

        /**
         * Метод addAfterListNumber добавляет элемент после заданного
         * @param x_ - добавляемый в список элемент
         * @param pN- указатель на элемент, после котрого необходимо добавить заданный
         */
        private void addAfterListNumber(T x_, Numbers <T> pN) {
                Numbers<T> p = new Numbers(x_);
                p.x = x_;
                p.next = pN.next;
                pN.next = p;
        }

    /**
         * Метод addNumber добавляет элемент в список на определенное место
         * @param x_ - добавляемый элемент
         * @param place_elem - место, в кторое необходимо добавить элемент
         * @return tmp = true в случае корректного добавления, т.е место добавления переданно корректно и false в случае ошибочно переданного места добавления элемента
         */

        public boolean addElem(T x_, int place_elem) {
            boolean tmp=false;
            if (place_elem <= size+1) {
                if (!isEmpty()) {
                    Numbers<T> p = findBeforePlace(head, place_elem);
                    if (p == null) addToHead(x_);
                    else addAfterListNumber(x_, p);
                }
                else addToHead(x_);
                size++;
                tmp=true;
            }
            return tmp;
        }

        /**
         * Метод deleteFromHead удаляет элемент из головы списка
         */
        private void deleteFromHead() {
            if (!isEmpty()) {
                    Numbers p = head;
                    head = p.next;
                    p.next = null;
                    p = null;
            }
        }

        /**
         * Метод deleteAfterListNumber удаляет элемент после заданного
         * @param pN - указатель на элемент списка, после котрого необходимо удалить элемент
         */
        private void deleteAfterListNumber(Numbers <T> pN) {
            Numbers<T> p = pN.next;
            if (p != null) {
                pN.next = p.next;
                p.next = null;
                p = null;
            }
        }

        /**
         * Метод deleteElem удаляет элемент из списка по заданному месту
         * @param place_elem - место, из которого необходимо удалить элемент
         * @return tmp = true в случае корректного добавления, т.е корректно переданного места и false в случае некорректного добавления
         */

        public boolean deleteElem(int place_elem) {
            boolean tmp=false;
            if (place_elem <= size ) {
                Numbers<T> p = findBeforePlace(head, place_elem);
                if (p == null) deleteFromHead();
                else deleteAfterListNumber(p);
                size--;
                tmp=true;
            }
            return tmp;
        }


        /**
         * Метод  getElem возвращает элемент по его месту
         * @param place_elem - местно элемента, которого надо просмотреть
         * @return elem или null в случае не нахождение элемента
         */

        public T getElem(int place_elem) {
            T x_;
            if (place_elem <= size) {
                Numbers<T> p = findBeforePlace(head, place_elem);
                if (p == null) x_= head.x;
                else x_ = p.next.x;
                return x_;
            }
            return null;
        }


        /**
         * Метод print выводит список элементов
         * @return rezult - список в виде строки
         */
        public String print() {
            String result=" ";
            if (!isEmpty()) {
                Numbers<T> p = head;
                while (p != null) {
                    result=result+p.x+" ";
                    p = p.next;
                }
            }
            else System.out.println("Контейнер пуст");
            return result;
        }
}


