public class App {
    public static void main(String[] args) throws Exception {
        db database = new db("jdbc:mysql://localhost:3306/hotel_usd", "root", "");
        database.connectDb();
        page.login loginPage = new page.login();    
        loginPage.setVisible(true);
        System.out.println("Connection closed.");
    }
}