package kursWork.service;

import kursWork.entity.*;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class Service {

    public static Socket socket = null;
    public static PrintStream printStream;
    public static BufferedReader bufferedReader;
    public static ObjectInputStream deserializer;
    public static ObjectOutputStream serializer;

    public static void connection() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), 8072);
        printStream = new PrintStream(socket.getOutputStream());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        serializer = new ObjectOutputStream(socket.getOutputStream());
        deserializer = new ObjectInputStream(socket.getInputStream());
    }

    public static User checkUser(String login, String password) {
        try {
            serializer.writeObject("Authorization");
            serializer.writeObject(login);
            serializer.writeObject(password);
            serializer.flush();
            User user = (User) deserializer.readObject();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * Administrator
     */

    public static List<User> getUsersForAdmin() {
        List<User> users = null;
        try {
            serializer.writeObject("PrintUsersForAdmin");
            users = (List<User>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static String deleteUsers(String user) {
        String str = null;
        try {
            serializer.writeObject("DeleteUser");
            serializer.writeObject(user);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static List<Worker> getWorkersForAdmin() {
        List<Worker> workers = null;
        try {
            serializer.writeObject("PrintWorkersForAdmin");
            workers = (List<Worker>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public static String deleteWorkers(String worker) {
        String str = null;
        try {
            serializer.writeObject("DeleteWorker");
            serializer.writeObject(worker);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String deleteExpert(String expert) {
        String str = null;
        try {
            serializer.writeObject("DeleteExpert");
            serializer.writeObject(expert);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static List<Expert> getExpertsForAdmin() {
        List<Expert> experts = null;
        try {
            serializer.writeObject("PrintExpertsForAdmin");
            experts = (List<Expert>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return experts;
    }

    public static String createNewExpert(User user, Expert expert)  {
        String str = null;
        try {
            serializer.writeObject("ExpertRegistration");
            serializer.writeObject(user);
            serializer.writeObject(expert);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String createNewWorker(User user, Worker worker) throws IOException {
        serializer.writeObject("WorkerRegistration");
        serializer.writeObject(user);
        serializer.writeObject(worker);
        serializer.flush();
        return bufferedReader.readLine();
    }

    public static String createNewClient(User user, Client client) throws IOException {
        serializer.writeObject("ClientRegistration");
        serializer.writeObject(user);
        serializer.writeObject(client);
        serializer.flush();
        return bufferedReader.readLine();
    }

    public static List<String> getAllCreditsType() {
        List<String> types = null;
        try {
            serializer.writeObject("ReadAllCreditsType");
            types = (List<String>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return types;
    }

    public static String addCreditsType(String type) {
        String str = null;
        try {
            serializer.writeObject("AddCreditsType");
            serializer.writeObject(type);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String deleteCreditsType(String type) {
        String str = null;
        try {
            serializer.writeObject("DeleteCreditsType");
            serializer.writeObject(type);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static List<Credit> getAllCredits() {
        List<Credit> credits = null;
        try {
            serializer.writeObject("ReadInfoAboutCredits");
            credits = (List<Credit>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return credits;
    }

    public static List<Credit> getAllCreditsForAssessment() {
        List<Credit> credits = null;
        try {
            serializer.writeObject("CreditsForAssessment");
            credits = (List<Credit>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return credits;
    }

    public static String addNewCredit(Credit credit) {
        String str = null;
        try {
            serializer.writeObject("AddCredit");
            serializer.writeObject(credit);
            serializer.flush();
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String deleteCredit(Credit credit) {
        String str = null;
        try {
            serializer.writeObject("DeleteCredit");
            serializer.writeObject(credit);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String deleteCreditForAssessment(Credit credit) {
        String str = null;
        try {
            serializer.writeObject("DeleteCreditForAssessment");
            serializer.writeObject(credit);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static List<Credit> getFindCredit(String columnName, String findString) {
        List<Credit> credits = null;
        try {
            serializer.writeObject("FindInfoAboutCredit");
            serializer.writeObject(columnName);
            serializer.writeObject(findString);
            credits = (List<Credit>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return credits;
    }

    public static int getIdCredit(Credit credit) {
        int id = -1;
        try {
            serializer.writeObject("GetIdCredit");
            serializer.writeObject(credit);
            id = (Integer) deserializer.readObject();
            System.out.println("id:" + id);
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static String editCredit(int id, Credit credit) {
        String str = null;
        try {
            serializer.writeObject("EditCredit");
            serializer.writeObject(id);
            serializer.writeObject(credit);
            serializer.flush();
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String sendCreditForAssessment(Credit credit) {
        String str = null;
        try {
            serializer.writeObject("SendCreditForAssessment");
            serializer.writeObject(credit);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String enterScaleSize(String size) {
        String str = null;
        try {
            serializer.writeObject("EnterScaleSize");
            serializer.writeObject(size);
            serializer.flush();
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static List<Expert> watchAllSummAssessments() {
        List<Expert> experts = null;
        try {
            serializer.writeObject("WatchAllSummAssessments");
            experts = (List<Expert>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return experts;
    }

    public static String getAssByNameAndSName(String sName, String name){
        String str = null;
        try {
            serializer.writeObject("GetAssByNameAndSName");
            serializer.writeObject(sName);
            serializer.writeObject(name);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    /**
     * Expert
     */

    public static List<Expert> getFindExpert(String columnName, String findString) {
        List<Expert> experts = null;
        try {
            serializer.writeObject("FindInfoAboutExpert");
            serializer.writeObject(columnName);
            serializer.writeObject(findString);
            experts = (List<Expert>) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return experts;
    }

    public static int getN() {
        int N = 0;
        try {
            serializer.writeObject("GetN");
            N = (Integer) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return N;
    }

    public static int getScale() {
        int scale = -1;
        try {
            serializer.writeObject("GetScale");
            scale = (Integer) deserializer.readObject();
            serializer.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return scale;
    }

    public static String addAssessments(String login, String expertAssessments) {
        String str = null;
        try {
            serializer.writeObject("AddAssessments");
            serializer.writeObject(login);
            serializer.writeObject(expertAssessments);
            str = bufferedReader.readLine();
            serializer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
