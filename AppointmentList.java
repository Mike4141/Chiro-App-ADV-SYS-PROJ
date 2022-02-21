
package business;
import java.util.ArrayList;

public class AppointmentList {
    
   
    ArrayList<AppointmentBO> appList = new ArrayList<AppointmentBO>();
    
    public void addPatient(AppointmentBO a1) {
        
        appList.add(a1);
        
    }
    
    public void displayList() {
        for(int x=0;x<appList.size();x++){
            System.out.println(appList.get(x));
            
        }
    }
    public static void main(String args[]){
        
        ArrayList<AppointmentBO> appList = new ArrayList<AppointmentBO>();
        AppointmentBO a1 = new AppointmentBO("3003", "2001", "4/4/2022", "1:00", "2:00");
        AppointmentBO a2 = new AppointmentBO("3003", "2001", "4/8/2022", "1:00", "2:00");
        AppointmentBO a3 = new AppointmentBO("3003", "2001", "4/12/2022", "1:00", "2:00");
        AppointmentBO a4 = new AppointmentBO("3003", "2001", "4/21/2022", "1:00", "2:00");
        appList.add(a1);
        appList.add(a2);
        appList.add(a3);
        appList.add(a4);
        
    
    
        
    }
}
