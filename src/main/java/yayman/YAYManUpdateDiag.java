/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * YAYManUpdateDiag.java
 *
 * Created on Jan 27, 2011, 4:06:08 PM
 */

package yayman;

import java.net.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.SwingWorker;
import org.jdesktop.application.Action;
import java.util.zip.*;
import java.util.*;
//import com.moviejukebox.tools.*;
//import static com.moviejukebox.tools.PropertiesUtil.*;
import java.util.concurrent.*;
import org.jdesktop.application.ResourceMap;

/**
 *
 * @author Dan
 */
public class YAYManUpdateDiag extends javax.swing.JDialog {
    Logger logger = Logger.getLogger("yayman");
    String dlPrefix = "http://yayman.googlecode.com/files/yayman_v";
    String dlSuffix = ".zip";
    String verDetailsPre = "http://code.google.com/p/yayman/downloads/detail?name=yayman_v";
    String verDetailsSuf = ".zip";
    VersionCheckSite vSite;
    YAYManView mainWindow;
    boolean noisy;
    boolean auto;

    /** Creates new form YAYManUpdateDiag */
    public YAYManUpdateDiag() {
        super();
        initComponents();

        noisy = false;
        
        auto = true;

        mainWindow = null;

        initUpdater();
    }
    
    public YAYManUpdateDiag(YAYManView parent, boolean n) {
        super(parent.getFrame(), false);
        initComponents();

        this.setLocationRelativeTo(parent.getFrame());

        noisy = n;
        
        auto = false;

        mainWindow = parent;

        initUpdater();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblLocalRev = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblRemoteRev = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(yayman.YAYManApp.class).getContext().getResourceMap(YAYManUpdateDiag.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setIconImage(null);
        setName("Form"); // NOI18N
        setResizable(false);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        lblLocalRev.setText(resourceMap.getString("lblLocalRev.text")); // NOI18N
        lblLocalRev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLocalRev.setName("lblLocalRev"); // NOI18N
        lblLocalRev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLocalRevMouseClicked(evt);
            }
        });

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        lblRemoteRev.setText(resourceMap.getString("lblRemoteRev.text")); // NOI18N
        lblRemoteRev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRemoteRev.setName("lblRemoteRev"); // NOI18N
        lblRemoteRev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoteRevMouseClicked(evt);
            }
        });

        lblStatus.setText(resourceMap.getString("lblStatus.text")); // NOI18N
        lblStatus.setName("lblStatus"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(yayman.YAYManApp.class).getContext().getActionMap(YAYManUpdateDiag.class, this);
        btnUpdate.setAction(actionMap.get("doUpdate")); // NOI18N
        btnUpdate.setText(resourceMap.getString("btnUpdate.text")); // NOI18N
        btnUpdate.setName("btnUpdate"); // NOI18N

        btnCancel.setAction(actionMap.get("closeForm")); // NOI18N
        btnCancel.setText(resourceMap.getString("btnCancel.text")); // NOI18N
        btnCancel.setName("btnCancel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLocalRev)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRemoteRev))
                    .addComponent(lblStatus)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblLocalRev)
                    .addComponent(jLabel2)
                    .addComponent(lblRemoteRev))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLocalRevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalRevMouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new URI("http://code.google.com/p/yayman/wiki/YAYManReadme"));
        } catch (Exception ex) {
            logger.severe("Error visiting readme page: "+ex);
        }
}//GEN-LAST:event_lblLocalRevMouseClicked

    private void lblRemoteRevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoteRevMouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new URI(vSite.getDownloadURL()));
        } catch (Exception ex) {
            logger.severe("Error visiting readme page: "+ex);
        }
}//GEN-LAST:event_lblRemoteRevMouseClicked

    public void initUpdater() {
        btnUpdate.setEnabled(false);

        ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(yayman.YAYManApp.class).getContext().getResourceMap(YAYManApp.class);
        javax.swing.ImageIcon frameIcon = resourceMap.getImageIcon("Application.updateIcon");
        this.setIconImage(frameIcon.getImage());

        lblLocalRev.setVisible(false);
        lblRemoteRev.setVisible(false);
        final String localVer = (String)resourceMap.getObject("Application.version", String.class);
        lblLocalRev.setText(localVer);
        lblLocalRev.setVisible(true);

        if (noisy) this.setVisible(true);
        new SwingWorker<Void,String>() {
            public Void doInBackground() {
                lblStatus.setText("Finding newest YAYMan version...");
                progressBar.setIndeterminate(true);
                try {
                    logger.fine("Checking for new version...");

                    final ArrayList<VersionCheckSite> sites = new ArrayList();
                    VersionCheckSite mpSite = new VersionCheckSite("http://mediaplayersite.com/YAYMan", "title");
                    mpSite.setBaseFileURL("mediaplayersite.com/system/files/1027-nordin/yayman_v");

                    VersionCheckSite site = new VersionCheckSite("http://code.google.com/p/yayman/wiki/CurrentVersion", "p");
                    site.setDownloadURL("http://code.google.com/p/yayman/downloads/list");
                    site.setBaseFileURL("yayman.googlecode.com/files/yayman_v");

                    sites.add(site);
                    sites.add(mpSite);
                    
                    //site = new VersionCheckSite();
                    //site.setDownloadURL("http://code.google.com/p/yayman/downloads/list");

                    int maxThreadsProcess, maxThreadsDownload = 0;
                    maxThreadsProcess = 0;//Integer.parseInt(getProperty("mjb.MaxThreadsProcess", "0"));
                    if (maxThreadsProcess <= 0) {
                        maxThreadsProcess = Runtime.getRuntime().availableProcessors();
                    }

                    maxThreadsDownload = 0;//Integer.parseInt(getProperty("mjb.MaxThreadsDownload", "0"));
                    if (maxThreadsDownload <= 0) {
                        maxThreadsDownload = maxThreadsProcess;
                    }

                    try {
                        //ThreadExecutor<Void> tasks = new ThreadExecutor<Void>(maxThreadsProcess, maxThreadsDownload);
                        ExecutorService taskExecutor = Executors.newFixedThreadPool(sites.size());
                        //final CountDownLatch latch = new CountDownLatch(sites.size());
                        Set<Callable<Void>> callables = new HashSet<Callable<Void>>();

                        for (int i = 0; i<sites.size(); i++) {
                            //final int sitei = i;
                            final VersionCheckSite currSite = sites.get(i);
                            logger.fine("Checking for new version at: "+currSite.getSiteURL());
                            //currSite.checkSiteWorker();
                            /*tasks.submit(new Callable<Void>() {
                                public Void call() {
                                    sites.get(sitei).checkSite();
                                    return null;
                                };
                            });*/
                            /*taskExecutor.execute(new Runnable() {
                               public void run() {
                                   currSite.checkSite();
                                   //latch.countDown();
                                   //try { synchronized(this) {latch.countDown(); } }
                                   //catch (Exception ex) { javax.swing.JOptionPane.showConfirmDialog(null, "oops: "+ex); }
                               } 
                            });*/
                            callables.add(new Callable<Void>() {
                                public Void call() {
                                    synchronized(currSite){
                                    currSite.checkSite();
                                    currSite.notifyAll();
                                    }
                                    return null;
                                };
                            });
                        }
                        //taskExecutor.shutdown();
                        //taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                        //synchronized (this) {latch.wait(); }
                        //tasks.waitFor();
                        taskExecutor.invokeAll(callables);
                        taskExecutor.shutdown();
                        /*boolean allFinished;
                        do {
                            allFinished = true;
                            for (int i=0; i<sites.size(); i++) {
                                VersionCheckSite s = sites.get(i);
                                //javax.swing.JOptionPane.showConfirmDialog(null, "checking for finished: "+s.getSiteURL());
                                if (!s.isCheckFinished()) {
                                    allFinished = false;
                                    //break;
                                }
                            }
                            
                            if (allFinished) {
                                //javax.swing.JOptionPane.showConfirmDialog(null, "all finished");
                                break;
                            } else {
                                //javax.swing.JOptionPane.showConfirmDialog(null, "not finished; sleeping");
                                Thread.currentThread().sleep(250);
                            }
                        } while (!allFinished);*/
                            
                    } catch (Exception ex) {
                        logger.severe(ex+" Error checking sites");
                    }

                    String version = localVer;
                    logger.fine("Local version: "+version);
                    boolean current = true;
                    boolean contacted = false;
                    for (int i = 0; i < sites.size(); i++) {
                        VersionCheckSite s = sites.get(i);
                        if (s.getConnectSuccess()) {
                            contacted = true;
                            logger.fine(s.getSiteURL()+" version: "+s.getVersion());
                            if (s.compareTo(version) > 0) {
                                site = s;
                                version = s.getVersion();
                                current = false;
                                break;
                            }
                        }
                    }

                    if (!contacted) {
                        logger.severe("Could not successfully communicate with any hosts");
                        lblStatus.setText("Unable to check for new version.");
                        btnCancel.setText("OK");
                        return null;
                    } else {
                        lblRemoteRev.setVisible(true);
                        lblRemoteRev.setText(version);
                        vSite = site;
                    }

                    if (current) {
                        logger.fine("No update necessary.");
                        lblStatus.setText("You are using the latest version.");
                        btnCancel.setText("OK");
                        if (auto) {
                            YAMJUpdateDiag yamjUpdate = new YAMJUpdateDiag();
                            yamjUpdate.setVisible(true);
                        }
                        if (!noisy) {
                            //YAYManUpdateDiag.this.closeForm();
                            YAYManUpdateDiag.this.setVisible(false);
                        }
                    } else if (!current) {
                        YAYManUpdateDiag.this.setVisible(true);
                        YAYManUpdateDiag.this.requestFocus();
                        logger.fine("New version available!");
                        lblStatus.setText("New version available!");
                        btnUpdate.setEnabled(true);
                        if (auto) {
                            javax.swing.JOptionPane.showConfirmDialog(null, "This version of YAYMan is out of date. Updating. You will be asked again to download YAMJ.", "Updating YAYMan", javax.swing.JOptionPane.OK_OPTION,javax.swing.JOptionPane.INFORMATION_MESSAGE);
                            doUpdate();
                        }
                    }
                } catch (Exception ex) {
                    logger.severe("Error getting YAYMan version: "+ex);
                }

                progressBar.setIndeterminate(false);
                return null;
            }
        }.execute();
    }
    
    @Action
    public void closeForm() {
        this.dispose();
    }

    @Action
    public void doUpdate() {
        if (btnUpdate.getText().toLowerCase().contains("restart")) {
            restartProgram();
            return;
        }
        btnUpdate.setEnabled(false);
        btnCancel.setEnabled(false);
        new SwingWorker<Void,String>() {
            public Void doInBackground() {
                try {
                    URL url = new URL(vSite.getFileURL());
                    URLConnection conn = url.openConnection();
                    int size = conn.getContentLength();
                    progressBar.getModel().setMaximum(size);
                    BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
                    FileOutputStream fos = new FileOutputStream("yaymanupdate.zip");
                    BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
                    byte data[] = new byte[1024];
                    int written = 0;
                    int x = 0;
                    while((x = in.read(data,0,1024)) >= 0) {
                        written += x;
                        bout.write(data,0,x);
                        if (written > size) written = size;
                        progressBar.setValue(written);
                        lblStatus.setText("Downloading YAYMan... "+written/1000+" kb / "+size/1000+" kb");
                    }
                    bout.flush();
                    bout.close();
                    in.close();

                } catch (Exception ex) {
                    logger.severe("Error downloading new YAYMan: "+ex);
                }
                unzipFiles();
                lblStatus.setText("Restart YAYMan to finish update.");
                if ((mainWindow != null && !mainWindow.busy()) || mainWindow == null) {
                    btnUpdate.setText("Restart now");
                    btnUpdate.setEnabled(true);
                    btnCancel.setText("Restart later");
                }
                btnCancel.setEnabled(true);
                return null;
            }
        }.execute();
    }

    @Action
    public void unzipFiles() {
        File yamjUpFile = new File("yaymanupdate.zip");
        if (yamjUpFile.exists()) {
            logger.fine("Updating YAYMan...");
            int BUFFER = 2048;
            int extracted = 0;
            try {
                BufferedOutputStream dest = null;
                 BufferedInputStream is = null;
                 ZipEntry entry;
                 ZipFile zipfile = new ZipFile(yamjUpFile);
                 progressBar.getModel().setMaximum(zipfile.size());
                 Enumeration e = zipfile.entries();
                 while(e.hasMoreElements()) {
                    extracted++;
                    progressBar.setValue(extracted);
                    entry = (ZipEntry) e.nextElement();
                    if (entry.isDirectory()) {
                        File dir = new File(entry.getName());
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                        continue;
                    }
                    logger.fine("Extracting: " +entry);
                    lblStatus.setText("Extracting files... "+extracted+" / "+zipfile.size());
                    is = new BufferedInputStream(zipfile.getInputStream(entry));
                    int count;
                    byte data[] = new byte[BUFFER];
                    FileOutputStream fos = new FileOutputStream(entry.getName());
                    dest = new BufferedOutputStream(fos, BUFFER);
                    while ((count = is.read(data, 0, BUFFER))
                      != -1) {
                       dest.write(data, 0, count);
                    }
                    dest.flush();
                    dest.close();
                    is.close();
                 }
                 zipfile.close();
                 yamjUpFile.delete();
                 
                 if (auto) restartProgram();
                 
            } catch (Exception ex) {
                logger.severe("Error extracting files: "+ex);
            }
        }
    }

    @Action
    public void restartProgram() {
        if (!YAYManApp.restartApplication(this)) {
            lblStatus.setText("Error: please restart manually.");
            logger.severe("Error: Unable to restart application automatically.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLocalRev;
    private javax.swing.JLabel lblRemoteRev;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables

}
