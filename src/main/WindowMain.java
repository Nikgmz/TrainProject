package main;

import job.JobApplication;
import train.SearchWindow;

import javax.swing.*;
import java.awt.*;

public class WindowMain extends JFrame {//towa tuka definira klasa kato naslednik na Jframe i shte e prozorec


    public WindowMain() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);//kato se zatwori prozoreca da se exitne
        setLayout(new FlowLayout());//towa definira kak shte ni izglezhda GUI
        setSize(500, 500);//nachalna golemina
        setTitle("train.Train Service App");//zaglawie
        JButton goToSearch = new JButton("Go and search for routes!");
        goToSearch.addActionListener(e -> {//towa se prawi i bez lambda ama warninga kaza da go smenq
            SearchWindow searchWindow = new SearchWindow();//otwarqme now prozorec
            dispose();//zatwarqme prozoreca
        });
        add(goToSearch);
        
       JButton goApplyJob = new JButton("Go and apply for a job!");
        goApplyJob.addActionListener(e->{//analogichno na predischnoto
            JobApplication jobApplication = new JobApplication();
            dispose();
        });
        add(goApplyJob);
        
        JButton goSeeInfo = new JButton("Go and learn about our organisation!");
        setVisible(true);
        //pack();
    }
}
