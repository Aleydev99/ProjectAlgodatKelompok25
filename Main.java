import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Menambahkan kelurahan
        graph.addVertex("Ampenan Selatan");
        graph.addVertex("Ampenan Tengah");
        graph.addVertex("Ampenan Utara");
        graph.addVertex("Banjar");
        graph.addVertex("Bintaro");
        graph.addVertex("Dayan Peken");
        graph.addVertex("Kebun Sari");
        graph.addVertex("Pajarakan Karya");
        graph.addVertex("Pejeruk");
        graph.addVertex("Taman Sari");
        graph.addVertex("Cakranegara Barat");
        graph.addVertex("Cakranegara Selatan");
        graph.addVertex("Cakranegara Selatan Baru");
        graph.addVertex("Cakranegara Timur");
        graph.addVertex("Cakranegara Utara");
        graph.addVertex("Cilinaya");
        graph.addVertex("Karang Taliwang");
        graph.addVertex("Mayura");
        graph.addVertex("Sapta Marga");
        graph.addVertex("Sayang-sayang");
        graph.addVertex("Mataram Timur");
        graph.addVertex("Pagesangan");
        graph.addVertex("Pagesangan Barat");
        graph.addVertex("Pagesangan Timur");
        graph.addVertex("Pagutan");
        graph.addVertex("Pagutan Barat");
        graph.addVertex("Pagutan Timur");
        graph.addVertex("Pejanggik");
        graph.addVertex("Punia");
        graph.addVertex("Abian Tubuh Baru");
        graph.addVertex("Babakan");
        graph.addVertex("Bertais");
        graph.addVertex("Dasan Cermen");
        graph.addVertex("Mandalika");
        graph.addVertex("Selagalas");
        graph.addVertex("Turida");
        graph.addVertex("Jempong Baru");
        graph.addVertex("Karang Pule");
        graph.addVertex("Kekalik Jaya");
        graph.addVertex("Tanjung Karang");
        graph.addVertex("Tanjung Karang Permai");
        graph.addVertex("Dasan Agung");
        graph.addVertex("Dasan Agung Baru");
        graph.addVertex("Gomong");
        graph.addVertex("Karang Baru");
        graph.addVertex("Mataram Barat");
        graph.addVertex("Monjok");
        graph.addVertex("Monjok Barat");
        graph.addVertex("Monjok Timur");
        graph.addVertex("Rembiga");

        // Menambahkan jarak antar kelurahan
        graph.insertEdge("Ampenan Selatan", "Ampenan Tengah", 4);
        graph.insertEdge("Ampenan Selatan", "Banjar", 7);
        graph.insertEdge("Ampenan Selatan", "Kebun Sari", 6);
        graph.insertEdge("Ampenan Selatan", "Taman Sari", 3);
        graph.insertEdge("Ampenan Tengah", "Banjar", 8);
        graph.insertEdge("Ampenan Tengah", "Kebun Sari", 5);
        graph.insertEdge("Ampenan Tengah", "Pajarakan Karya", 2);
        graph.insertEdge("Ampenan Tengah", "Pejeruk", 9);
        graph.insertEdge("Ampenan Utara", "Banjar", 3);
        graph.insertEdge("Ampenan Utara", "Dayan Peken", 6);
        graph.insertEdge("Banjar", "Kebun Sari", 4);
        graph.insertEdge("Banjar", "Pajarakan Karya", 5);
        graph.insertEdge("Bintaro", "Kebun Sari", 8);
        graph.insertEdge("Bintaro", "Pajarakan Karya", 7);
        graph.insertEdge("Bintaro", "Taman Sari", 2);
        graph.insertEdge("Dayan Peken", "Kebun Sari", 5);
        graph.insertEdge("Dayan Peken", "Pajarakan Karya", 4);
        graph.insertEdge("Kebun Sari", "Taman Sari", 8);
        graph.insertEdge("Taman Sari", "Cakranegara Barat", 9);
        graph.insertEdge("Cakranegara Barat", "Cakranegara Selatan", 4);
        graph.insertEdge("Cakranegara Selatan", "Cakranegara Selatan Baru", 3);
        graph.insertEdge("Cakranegara Selatan", "Cakranegara Timur", 6);
        graph.insertEdge("Cakranegara Timur", "Cakranegara Utara", 5);
        graph.insertEdge("Cakranegara Utara", "Cilinaya", 7);
        graph.insertEdge("Cilinaya", "Karang Taliwang", 4);
        graph.insertEdge("Karang Taliwang", "Mayura", 2);
        graph.insertEdge("Mayura", "Sapta Marga", 3);
        graph.insertEdge("Sapta Marga", "Sayang-sayang", 4);
        graph.insertEdge("Sayang-sayang", "Mataram Timur", 5);
        graph.insertEdge("Mataram Timur", "Pagesangan", 3);
        graph.insertEdge("Pagesangan", "Pagesangan Barat", 4);
        graph.insertEdge("Pagesangan Barat", "Pagesangan Timur", 5);
        graph.insertEdge("Pagesangan Timur", "Pagutan", 6);
        graph.insertEdge("Pagutan", "Pagutan Barat", 3);
        graph.insertEdge("Pagutan Barat", "Pagutan Timur", 7);
        graph.insertEdge("Pagutan Timur", "Pejanggik", 8);
        graph.insertEdge("Pejanggik", "Punia", 9);
        graph.insertEdge("Punia", "Abian Tubuh Baru", 4);
        graph.insertEdge("Abian Tubuh Baru", "Babakan", 5);
        graph.insertEdge("Babakan", "Bertais", 6);
        graph.insertEdge("Bertais", "Dasan Cermen", 8);
        graph.insertEdge("Dasan Cermen", "Mandalika", 7);
        graph.insertEdge("Mandalika", "Selagalas", 3);
        graph.insertEdge("Selagalas", "Turida", 5);
        graph.insertEdge("Turida", "Jempong Baru", 4);
        graph.insertEdge("Jempong Baru", "Karang Pule", 2);
        graph.insertEdge("Karang Pule", "Kekalik Jaya", 6);
        graph.insertEdge("Kekalik Jaya", "Tanjung Karang", 3);
        graph.insertEdge("Tanjung Karang", "Tanjung Karang Permai", 5);
        graph.insertEdge("Tanjung Karang Permai", "Dasan Agung", 4);

        // Menambahkan edge antar kelurahan yang terhubung
        graph.insertEdge("Gomong", "Karang Baru", 5);
        graph.insertEdge("Gomong", "Mataram Barat", 6);
        graph.insertEdge("Karang Baru", "Dasan Agung", 4);
        graph.insertEdge("Mataram Barat", "Gomong", 5);
        graph.insertEdge("Dasan Agung", "Monjok Barat", 3);
        graph.insertEdge("Monjok Barat", "Monjok Timur", 4);
        graph.insertEdge("Monjok Timur", "Selaparang", 6);
        graph.insertEdge("Monjok", "Selaparang", 7);
        graph.insertEdge("Selaparang", "Dasan Agung Baru", 2);
        graph.insertEdge("Dasan Agung Baru", "Karang Baru", 6);
        
        Scanner sc = new Scanner(System.in);

        // Input lokasi driver
        System.out.print("Masukkan lokasi driver: ");
        String lokasiDriver = sc.nextLine();
        Vertex driver = graph.searchVertex(lokasiDriver);

        // Input lokasi customer
        System.out.print("Masukkan lokasi customer: ");
        String lokasiCustomer = sc.nextLine();
        Vertex customer = graph.searchVertex(lokasiCustomer);

        // Input tujuan customer
        System.out.print("Masukkan lokasi tujuan customer: ");
        String lokasiTujuan = sc.nextLine();
        Vertex tujuan = graph.searchVertex(lokasiTujuan);

        if (driver == null || customer == null || tujuan == null) {
            System.out.println("Salah satu lokasi tidak valid.");
            return;
        }

        // Jalur driver ke customer
        System.out.println("\nJalur tercepat dari driver ke customer:");
        graph.dijkstra(driver, customer);

        // Jalur customer ke tujuan
        System.out.println("\nJalur tercepat dari customer ke tujuan:");
        graph.dijkstra(customer, tujuan);
    }
}
