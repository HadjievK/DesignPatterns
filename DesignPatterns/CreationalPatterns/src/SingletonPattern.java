class SingleObject{
    private static  SingleObject singleObject;
    private  SingleObject(){
        System.out.println("this is singleton pattern");

    }
//Thread Safe Singleton - synchronized
    public static synchronized SingleObject getInstance(){
        if (singleObject == null)
        {
            singleObject = new SingleObject();
        }
        return singleObject;
    }

//double checking locking
/*public static  SingleObject getInstance(){
    if (singleObject == null)
    {
        synchronized (SingleObject.class) {

            if(singleObject == null)
                singleObject = new SingleObject();
        }
    }
    return singleObject;
}*/

}


public class SingletonPattern {
    public static void main(String[] args){

        SingleObject singleObject = SingleObject.getInstance();

    }
}
