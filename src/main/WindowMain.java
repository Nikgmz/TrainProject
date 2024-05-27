package main;

import job.JobApplication;
import train.SearchWindow;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowMain extends JFrame {//towa tuka definira klasa kato naslednik na Jframe i shte e prozorec


    public WindowMain() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);//kato se zatwori prozoreca da se exitne
        setLayout(new BorderLayout());//towa definira kak shte ni izglezhda GUI
        //setSize(500, 500);//nachalna golemina
        setTitle("Train Service App");//zaglawie




        JButton goToSearch = new JButton("Go and search for routes!");
        goToSearch.addActionListener(e -> {//towa se prawi i bez lambda ama warninga kaza da go smenq
            SearchWindow searchWindow = new SearchWindow();//otwarqme now prozorec
            dispose();//zatwarqme prozoreca
        });
        
       JButton goApplyJob = new JButton("Go and apply for a job!");
        goApplyJob.addActionListener(e->{//analogichno na predischnoto
            JobApplication jobApplication = new JobApplication();
            dispose();
        });

        
        JButton goSeeInfo = new JButton("Go and learn about our organisation!");//kodut wuw funkciqta e za otwarqne na url
        goSeeInfo.addActionListener(e -> {//kopiran ot stackoverflow
            Runtime rt = Runtime.getRuntime();
            String url = "https://bg.wikipedia.org/wiki/Български_държавни_железници";
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        JPanel train = new JPanel();
        JPanel job = new JPanel();
        JPanel info = new JPanel();
        JPanel image = new JPanel();

        train.add(goToSearch);
        add(train, BorderLayout.EAST);
        job.add(goApplyJob);
        add(job, BorderLayout.CENTER);
        info.add(goSeeInfo);
        add(info, BorderLayout.WEST);
        image.add(new JLabel(new ImageIcon("bdzh.png")));
        add(image, BorderLayout.PAGE_END);
        setVisible(true);//estetichekso podrezhdane sprqmo wuzmozhnostite na layouta
        pack();
    }
}
