/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * YAMJUpdateDiag.java
 *
 * Created on Jan 27, 2011, 4:27:57 PM
 */

package yayman;

import java.net.*;
import java.io.*;
import java.util.logging.*;
import java.util.regex.*;
import javax.swing.SwingWorker;
import org.jdesktop.application.Action;
import java.util.zip.*;
import java.util.*;

/**
 *
 * @author Dan
 */
public class YAMJUpdateDiag extends javax.swing.JDialog {
    Logger logger = Logger.getLogger("yayman");
    //String dlPrefix = "http://mediaplayersite.com/sites/default/files/YAMJ/yamj-";
    //String dlSuffix = "-bin.zip";
    String revDetails = "http://code.google.com/p/moviejukebox/source/detail?r=";
    String downloadUrl = "";
    YAYManView mainWindow;
    boolean autoUpdate;
    int requiredRev;
    int localRev;
    ArrayList<String> jarNames;

    public YAMJUpdateDiag() {
        this(true);
    }

    public YAMJUpdateDiag(boolean auto) {
        super();
        initComponents();

        mainWindow = null;
        autoUpdate = auto;
        initialize();
    }

    public YAMJUpdateDiag(YAYManView parent) {
        this(parent, false);
    }

    /** Creates new form YAMJUpdateDiag */
    public YAMJUpdateDiag(YAYManView parent, boolean auto) {
        super(parent.getFrame(), false);
        initComponents();
        
        this.setLocationRelativeTo(parent.getFrame());

        mainWindow = parent;
        autoUpdate = auto;

        initialize();
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
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(yayman.YAYManApp.class).getContext().getResourceMap(YAMJUpdateDiag.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
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

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(yayman.YAYManApp.class).getContext().getActionMap(YAMJUpdateDiag.class, this);
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
            .addGap(0, 279, Short.MAX_VALUE)
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
            .addGap(0, 127, Short.MAX_VALUE)
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
            java.awt.Desktop.getDesktop().browse(new URI(revDetails+lblLocalRev.getText().replaceAll("r", "")));
        } catch (Exception ex) {
            YAYManView.logger.severe("Error visiting revision page: "+ex);
        }
}//GEN-LAST:event_lblLocalRevMouseClicked

    private void lblRemoteRevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoteRevMouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new URI(revDetails+lblRemoteRev.getText().replaceAll("r", "")));
        } catch (Exception ex) {
            YAYManView.logger.severe("Error visiting revision page: "+ex);
        }
}//GEN-LAST:event_lblRemoteRevMouseClicked

    @Action
    public void closeForm() {
        this.dispose();
    }

    public void initialize() {
        btnUpdate.setEnabled(false);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(yayman.YAYManApp.class).getContext().getResourceMap(YAYManApp.class);
        javax.swing.ImageIcon frameIcon = resourceMap.getImageIcon("Application.updateIcon");
        this.setIconImage(frameIcon.getImage());

        lblLocalRev.setVisible(false);
        lblRemoteRev.setVisible(false);
        requiredRev = resourceMap.getInteger("Application.minRevision").intValue();
        localRev = 0;
        if (autoUpdate) {
            lblLocalRev.setText("None");
        } else {
            localRev = JukeboxInterface.getYAMJRevision();
            lblLocalRev.setText("r"+localRev);
        }
        lblLocalRev.setVisible(true);

        new SwingWorker<Void,String>() {
            public Void doInBackground() {
                lblStatus.setText("Finding newest YAMJ revision...");
                progressBar.setIndeterminate(true);
                String html = "";
                try {
                    YAMJDownloadSite site1 = new YAMJDownloadSite();
                    YAMJDownloadSite site2 = new YAMJDownloadSite("http://mediaplayersite.martysweb.net/");
                    site2.setPrefix("http://mediaplayersite.martysweb.net/YAMJ/yamj-");
                    site1 = site2; //remove once mediaplayersite is better
                    String dlPrefix = site1.getPrefix();
                    String dlSuffix = site1.getSuffix();
                    try {
                        BufferedReader read = new BufferedReader(new InputStreamReader(site1.getUrl().openStream()));
                        String line = read.readLine();
                        while (line != null) {
                            html += line;
                            line = read.readLine();
                        }
                    } catch (Exception ex) {
                        BufferedReader read = new BufferedReader(new InputStreamReader(site2.getUrl().openStream()));
                        String line = read.readLine();
                        while (line != null) {
                            html += line;
                            line = read.readLine();
                        }
                        dlPrefix = site2.getPrefix();
                        dlSuffix = site2.getSuffix();
                    }

                    Pattern p = Pattern.compile(dlPrefix+"(.+?)"+"r(\\d{4,})"+dlSuffix);
                    Matcher m = p.matcher(html);
                    while (m.find()) {
                        int remoteRev = Integer.parseInt(m.group(2).replaceAll("r", ""));
                        lblRemoteRev.setText("r"+remoteRev);
                        lblRemoteRev.setVisible(true);
                        downloadUrl = m.group();
                        if (localRev < remoteRev && remoteRev > requiredRev) btnUpdate.setEnabled(true);
                        break;
                    }
                } catch (Exception ex) {
                    logger.severe("Error getting YAMJ revisions: "+ex);
                }
                lblStatus.setText("New revision available!");
                if (!btnUpdate.isEnabled()) {
                    lblStatus.setText("You are using the latest revision.");
                    btnCancel.setText("OK");
                }
                progressBar.setIndeterminate(false);
                if (autoUpdate) doUpdate();
                return null;
            }
        }.execute();
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
                    URL url = new URL(downloadUrl);
                    
                    URLConnection conn = url.openConnection();
                    int size = conn.getContentLength();
                    progressBar.getModel().setMaximum(size);
                    BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
                    FileOutputStream fos = new FileOutputStream("yaymanyamjupdate.zip");
                    BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
                    byte data[] = new byte[1024];
                    int written = 0;
                    int x = 0;
                    while((x = in.read(data,0,1024)) >= 0) {
                        written += x;
                        bout.write(data,0,x);
                        if (written > size) written = size;
                        progressBar.setValue(written);
                        lblStatus.setText("Downloading YAMJ... "+written/1000+" kb / "+size/1000+" kb");
                    }
                    bout.flush();
                    bout.close();
                    in.close();
                } catch (Exception ex) {
                    logger.severe("Error downloading new YAMJ: "+ex);
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
        setJarNames();
        File yamjUpFile = new File("yaymanyamjupdate.zip");
        if (yamjUpFile.exists()) {
            logger.fine("Updating YAMJ...");
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
                    progressBar.setValue(extracted);
                    extracted++;
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
                    String destName = getDestName(entry.getName());
                    FileOutputStream fos = new FileOutputStream(destName);
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

                if (autoUpdate) restartProgram();

            } catch (Exception ex) {
                logger.severe("Error extracting files: "+ex);
            }
        }
    }

    @Action
    public void restartProgram() {
        if (!YAYManApp.restartApplication(this)) {
            lblStatus.setText("You must restart manually");
            logger.severe("Error: Unable to restart application automatically.");
        }
    }
    
    private String getDestName(String origName) {
        String name = origName;
        
        for (String jar : jarNames) {
            if (name.startsWith("lib/"+jar)) {
                name = "lib/"+jar+".jar";
                break;
            }
        }
        
        return name;
    }
    
    private void setJarNames() {
        jarNames = YAYManApp.getJars();
        /*jarNames = new ArrayList();
        jarNames.add("allocine-api");
        jarNames.add("anidb");
        jarNames.add("apirottentomatoes");
        jarNames.add("commons-beanutils-core");
        jarNames.add("commons-beanutils");
        jarNames.add("commons-codec");
        jarNames.add("commons-collections");
        jarNames.add("commons-configuration");
        jarNames.add("commons-digester");
        jarNames.add("commons-io");
        jarNames.add("commons-lang3");
        jarNames.add("commons-lang");
        jarNames.add("commons-logging");
        jarNames.add("fanarttvapi");
        jarNames.add("filters");
        jarNames.add("jackson-core-lgpl");
        jarNames.add("jackson-mapper-lgpl");
        jarNames.add("javolution");
        jarNames.add("jaxb-impl");
        jarNames.add("jpa-api");
        jarNames.add("json");
        jarNames.add("log4j");
        jarNames.add("mjbsqldb");
        jarNames.add("mucommander");
        jarNames.add("ormlite-core");
        jarNames.add("ormlite-jdbc");
        jarNames.add("pojava");
        jarNames.add("saxonhe");
        jarNames.add("simmetrics");
        jarNames.add("sqlite-jdbc");
        jarNames.add("themoviedbapi");
        jarNames.add("thetvdbapi");
        jarNames.add("tvrageapi");
        jarNames.add("ws-commons-util");
        jarNames.add("xml-apis");
        jarNames.add("xmlrpc-client");
        jarNames.add("xmlrpc-common");
        jarNames.add("yamj");*/
    }

    public class YAMJDownloadSite {
        String dlPrefix;
        String dlSuffix;
        //String matchPattern;
        URL url;
        public YAMJDownloadSite() throws java.net.MalformedURLException {
            dlPrefix = "http://mediaplayersite.com/sites/default/files/YAMJ/yamj-";
            dlSuffix = "-bin.zip";
            url = new URL("http://mediaplayersite.com/Yamj_Latest");
            //matchPattern = dlPrefix+"(.+?)"+"r(\\d{4,})"+dlSuffix;
        }

        public YAMJDownloadSite(String sUrl) throws java.net.MalformedURLException {
            dlPrefix = null;
            dlSuffix = "-bin.zip";
            url = new URL(sUrl);
        }

        public URL getUrl() {
            return url;
        }

        public String getPrefix() {
            return dlPrefix;
        }

        public String getSuffix() {
            return dlSuffix;
        }

        public void setUrl(URL u) {
            url = u;
        }

        public void setUrl (String u) throws java.net.MalformedURLException {
            url = new URL(u);
        }

        public void setPrefix(String p) {
            dlPrefix = p;
        }

        public void setSuffix(String s) {
            dlSuffix = s;
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
