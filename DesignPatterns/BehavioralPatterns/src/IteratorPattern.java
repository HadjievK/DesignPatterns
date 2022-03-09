import javax.management.NotificationBroadcaster;

interface Iterator {

    boolean hasNext();

    Object next();
}

class Notification {
    String notification;

    public Notification(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}

interface Collection {
    public Iterator createIterator();
}

class NotificationIterator implements Iterator {

    Notification[] notificationList;
    int pos = 0;

    public NotificationIterator(Notification[] notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public boolean hasNext() {
        if (pos >= notificationList.length || notificationList[pos] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Notification notification = notificationList[pos];
        pos += 1;
        return notification;
    }
}


class NotificationCollection implements Collection {
    static final int MAX_SIZE = 6;
    int numberOfItems = 0;
    Notification[] notificationList;

    public NotificationCollection() {
        notificationList = new Notification[MAX_SIZE];
        addItem("notification 1");
        addItem("notification 2");
        addItem("notification 3");
    }

    public void addItem(String name) {
        Notification notification = new Notification(name);
        if (numberOfItems >= MAX_SIZE) {
            System.err.println("full");
        } else {
            notificationList[numberOfItems] = notification;
            numberOfItems++;
        }

    }

    @Override
    public Iterator createIterator() {
        return new NotificationIterator(notificationList);
    }
}

class NotificationBar {
    NotificationCollection notificationCollection;

    public NotificationBar(NotificationCollection notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    public void print(){
         Iterator iterator = notificationCollection.createIterator();
         System.out.println("------------Notification Bar------------");
         while(iterator.hasNext()){
             Notification n = (Notification) iterator.next();
             System.out.println(n.getNotification());
         }
    }
}


public class IteratorPattern {
    public static void main(String[] args) {
        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);
        nb.print();
    }
}
