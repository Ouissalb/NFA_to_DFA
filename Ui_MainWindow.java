/* **************************************************************************** */
/*                                                                              */
/*             PROJET : CONVERSION D'UN AFN EN UN AFD ET/OU LE MINIMISER        */
/*                                                                              */
/* **************************************************************************** */

package afnTOafd;
import java.util.*;

import com.trolltech.qt.gui.* ;
import com.trolltech.qt.core.*;

public class Ui_MainWindow extends QMainWindow
{
	public static Afn exemple1;
	public static Afntoafd exemple2;
	
	/***********************************************************************************
	 *                               DECLARATIONS
	 ***********************************************************************************/
	
	// declaration des variables, buttons, widgets ..etc pour la MainWindow
	public static QMainWindow initWindow;
    public static QWidget centralwidgetMainWin;
    public static QWidget verticalLayoutWidgetMainWin;
    public static QVBoxLayout verticalLayoutMainWin;
    public static QPushButton convertAndMinimizeNfaButton;
    public static QPushButton displayDFAButton;
    public static QPushButton minimizeDfaButton;
    public static QPushButton quitterButtonMainWin;
    public static QPushButton AboutUsButton;
    public static QTextBrowser textBrowserMainWindow;
    public static QMenuBar menubarMainWin;
    public static QStatusBar statusbarMainWin;
    
    // declaration des variables .. etc pour la deuxieme window (saisir symbole ... etc)
    public QWidget centralwidgetCheckboxes1;
    public QWidget verticalLayoutWidgetCheckboxes1;
    public QVBoxLayout verticalLayoutCheckboxes1;
    public QPushButton addSymbol;
    public QPushButton removeSymbol;
    public QPushButton displayAlphabet;
    public QPushButton displayAlphabetSize;
    public QTextBrowser textBrowserCheckboxes1;
    public QPushButton quitButtonCheckboxes1;
    public QPushButton nextButtonCheckboxes1;
    public QPushButton quitButton1;
    
    //fin de checkboxes1 declarations
    
    // Declarations pour le "add symbols" dialog box (pour ajouter un nouveau symbole)
    
    public QPushButton quitButtonAddSymbolBox;
    public QPushButton addSymbolPopUpBoxButton;
    public QLineEdit enterSymbolEditBox;
    public QLabel saisirSymboleLabel;
    public QLabel errorSymbolAlreadyExist;
    public QDialog addSymbolDialogBox;
    public boolean errorSymbolShown = false;
    

    // Declarations pour le "del symbols" dialog box (pour supprimer un symbole)
    
    public QPushButton quitButtonDelSymbolBox;
    public QPushButton delSymbolPopUpBoxButton;
    public QComboBox delSymbolComboBox;
    public QLabel delSymbolLabel;
    public QLabel errorSymbolsEmpty;
    public QDialog delSymbolDialogBox;
    
    // Le message box qui apparait quand l'utilisateur essaye de supprimer un symbole
    // alors qu'il n'a pas encore saisi de symboles
    
    public QMessageBox warnSymbolEmpty;
    public QMessageBox warnSymbolNull; 
    
    // Message box pour afficher l'alphabet   
    public QMessageBox displayAlphabetMsgBox;
    
    // Message box pour afficher la taille de l'alphabet   
    public QMessageBox displayAlphabetSizeMsgBox;



    // fin de Add symbol diolog box declarations
    
    /*************************************************************************************
     ************************  La Main Window du programme     ***************************
     *************************************************************************************/
    
   //fonction de la mainWindow
    public Ui_MainWindow()
    {
    	//The main window (la premiere fênetre)

        setObjectName("MainWindow");
        // taille
        resize(new QSize(800, 600).expandedTo(this.minimumSizeHint()));
        centralwidgetMainWin = new QWidget(this);
        centralwidgetMainWin.setObjectName("centralwidgetMainWin");
        verticalLayoutWidgetMainWin = new QWidget(centralwidgetMainWin);
        verticalLayoutWidgetMainWin.setObjectName("verticalLayoutWidgetMainWin");
        verticalLayoutWidgetMainWin.setGeometry(new QRect(160, 150, 491, 311));
        verticalLayoutMainWin = new QVBoxLayout(verticalLayoutWidgetMainWin);
        verticalLayoutMainWin.setObjectName("verticalLayoutMainWin");
        convertAndMinimizeNfaButton = new QPushButton(verticalLayoutWidgetMainWin);
        convertAndMinimizeNfaButton.setObjectName("convertAndMinimizeNfaButton");
        
        
        verticalLayoutMainWin.addWidget(convertAndMinimizeNfaButton);
        
        
        displayDFAButton = new QPushButton(verticalLayoutWidgetMainWin);
        
        displayDFAButton.setObjectName("displayDFAButton");

        verticalLayoutMainWin.addWidget(displayDFAButton);

        minimizeDfaButton = new QPushButton(verticalLayoutWidgetMainWin);
        minimizeDfaButton.setObjectName("minimizeDfaButton");

        verticalLayoutMainWin.addWidget(minimizeDfaButton);

        quitterButtonMainWin = new QPushButton(verticalLayoutWidgetMainWin);
        quitterButtonMainWin.setObjectName("quitterButtonMainWin");

        verticalLayoutMainWin.addWidget(quitterButtonMainWin);

        AboutUsButton = new QPushButton(centralwidgetMainWin);
        AboutUsButton.setObjectName("AboutUsButton");
        AboutUsButton.setGeometry(new QRect(660, 490, 121, 28));
        
       //Les informations du header
        textBrowserMainWindow = new QTextBrowser(centralwidgetMainWin);
        textBrowserMainWindow.setObjectName("textBrowserMainWindow");
        textBrowserMainWindow.setGeometry(new QRect(30, 20, 741, 101));
       
        //Attacher le widget à la fênetre
        
        setCentralWidget(centralwidgetMainWin);
        menubarMainWin = new QMenuBar(this);
        menubarMainWin.setObjectName("menubarMainWin");
        menubarMainWin.setGeometry(new QRect(0, 0, 800, 28));
        setMenuBar(menubarMainWin);
        statusbarMainWin = new QStatusBar(this);
        statusbarMainWin.setObjectName("statusbarMainWin");
        setStatusBar(statusbarMainWin);
        
        //Ajouter le texte au bouttons ..etc, de la MainWindow
        retranslateUi(this);
        
        //quitter
        quitterButtonMainWin.pressed.connect(this, "close()");
        convertAndMinimizeNfaButton.clicked.connect(this, "setupCheckboxes1()"); 

        connectSlotsByName();
        show();
    } 

    static void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "AFN to DFA programme", null));
        convertAndMinimizeNfaButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Convertir un AFN en un AFD et le minimiser", null));
        displayDFAButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher un AFD", null));
        minimizeDfaButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Minimiser un AFD", null));
        quitterButtonMainWin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
        AboutUsButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00c0 propos de nous", null));
        textBrowserMainWindow.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC"
        		+ " \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
        		"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
        		"p, li { white-space: pre-wrap; }\n"+
        		"</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400;"
        		+ " font-style:normal;\">\n"+"<p align=\"center\" style=\"-qt-paragraph-type:empty; "
        		+ "margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; "
        		+ "text-indent:0px;\"><br /></p>\n"+"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;"
        		+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" "
        		+ "font-size:12pt; text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" "
        		+ "font-size:12pt; font-weight:600; text-decoration: underline;\">AFN </span><span style=\" "
        		+ "font-size:12pt; text-decoration: underline;\">EN UN </span><span style=\" font-size:12pt;"
        		+ " font-weight:600; text-decoration: underline;\">AFD</span></p>\n"+
        		"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px;"
        		+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt;"
        		+ " font-weight:600; text-decoration: underline;\"><br /></p>\n"+
        		"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; "
        		+ "margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Ce programme permet de convertir "
        		+ "un <span style=\" font-weight:600;\">AFD</span> en un <span style=\" font-weight:600;\">AFD</span>"
        		+ " et/ou le minimiser.</p></body></html>", null));
    } 
    

	/***********************************************************************************
	 **********************    FONCTION DE LA SECONDE FENÊTRE   ************************
	 ***********************************************************************************/
    
 public void setupCheckboxes1() 
 {
	//Cacher le contenu du widget central
	centralwidgetMainWin.hide();
	 
	//Creer un nouveau widget vcentral pour la deuxieme fênetre
	centralwidgetCheckboxes1 = new QWidget(this);
	 
	
     centralwidgetCheckboxes1.setObjectName("centralwidgetCheckboxes1");
     //new vertical layout pour le deuxieme widget
     verticalLayoutWidgetCheckboxes1 = new QWidget(centralwidgetCheckboxes1);
     verticalLayoutWidgetCheckboxes1.setObjectName("verticalLayoutWidgetCheckboxes1");
     verticalLayoutWidgetCheckboxes1.setGeometry(new QRect(160, 150, 491, 311));
     verticalLayoutCheckboxes1 = new QVBoxLayout(verticalLayoutWidgetCheckboxes1);
     verticalLayoutCheckboxes1.setObjectName("verticalLayoutCheckboxes1");
     
    // le boutton "Ajouter un symbol"
     addSymbol = new QPushButton(verticalLayoutWidgetCheckboxes1);
     addSymbol.setObjectName("addSymbol");

     //Ajout du boutton "ajouter un symbol" dans le Vertical Layout
     verticalLayoutCheckboxes1.addWidget(addSymbol);

     removeSymbol = new QPushButton(verticalLayoutWidgetCheckboxes1);
     removeSymbol.setObjectName("removeSymbol");

     verticalLayoutCheckboxes1.addWidget(removeSymbol);

     displayAlphabet = new QPushButton(verticalLayoutWidgetCheckboxes1);
     displayAlphabet.setObjectName("displayAlphabet");

     verticalLayoutCheckboxes1.addWidget(displayAlphabet);

     displayAlphabetSize = new QPushButton(verticalLayoutWidgetCheckboxes1);
     displayAlphabetSize.setObjectName("displayAlphabetSize");

     verticalLayoutCheckboxes1.addWidget(displayAlphabetSize);
     
     // Header de la deuxieme fenetre
     
     textBrowserCheckboxes1 = new QTextBrowser(centralwidgetCheckboxes1);
     textBrowserCheckboxes1.setObjectName("textBrowserCheckboxes1");
     textBrowserCheckboxes1.setGeometry(new QRect(30, 20, 741, 101));
     //quit button
     quitButton1 = new QPushButton(centralwidgetCheckboxes1);
     quitButton1.setObjectName("quitButton1");
     quitButton1.setGeometry(new QRect(680, 490, 82, 28));
     nextButtonCheckboxes1 = new QPushButton(centralwidgetCheckboxes1);
     nextButtonCheckboxes1.setObjectName("nextButtonCheckboxes1");
     nextButtonCheckboxes1.setGeometry(new QRect(590, 490, 82, 28));
     this.setCentralWidget(centralwidgetCheckboxes1);
        
     quitButton1.clicked.connect(this, "close()");
     addSymbol.clicked.connect(this, "addSymbolsBox()"); //Call addSymbols() quand l'utilisateur clique sur ce boutton
     displayAlphabet.clicked.connect(this, "displayAlphabetMessageBox()"); 
     displayAlphabetSize.clicked.connect(this, "displayAlphabetSizeMessageBox()"); 
     
     addSymbol.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ajouter un symbole", null));
     removeSymbol.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Supprimer un symbole", null));
     displayAlphabet.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher un alphabet", null));
     displayAlphabetSize.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher la taille d'un alphabet", null));
     textBrowserCheckboxes1.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC"
     		+ " \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
     		"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
     		"p, li { white-space: pre-wrap; }\n"+
     		"</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; "
     		+ "font-style:normal;\">\n"+"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; "
     		+ "margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><br />"
     		+ "</p>\n"+"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; "
     		+ "margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:12pt;"
     		+ " text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" font-size:12pt; font-weight:600;"
     		+ " text-decoration: underline;\">AFN </span><span style=\" font-size:12pt; text-decoration: underline;\">"
     		+ "EN UN </span><span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span>"
     		+ "</p>\n"+"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; "
     		+ "margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; font-weight:600;"
     		+ " text-decoration: underline;\"><br /></p>\n"+
     		"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px;"
     		+ " -qt-block-indent:0; text-indent:0px;\">Ce programme permet de convertir un <span style=\" "
     		+ "font-weight:600;\">AFD</span> en un <span style=\" font-weight:600;\">AFD</span> et/ou le minimiser."
     		+ "</p></body></html>", null));
     
     quitButton1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
     nextButtonCheckboxes1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));     centralwidgetCheckboxes1.show();
     removeSymbol.clicked.connect(this, "delSymbolsBox()");
     centralwidgetCheckboxes1.show();
     this.connectSlotsByName();
 }

	/***********************************************************************************
	 ****************    LE DIALOG BOX POUR AJOUTER UN SYMBOLE  ************************
	 ***********************************************************************************/
 
    public void addSymbolsBox()
    {
    	
    	addSymbolDialogBox = new QDialog(centralwidgetCheckboxes1);
    	addSymbolDialogBox.setObjectName("addSymbolDialogBox");
        addSymbolDialogBox.setEnabled(true);
        addSymbolDialogBox.resize(new QSize(392, 235).expandedTo(addSymbolDialogBox.minimumSizeHint()));
        quitButtonAddSymbolBox = new QPushButton(addSymbolDialogBox);
        quitButtonAddSymbolBox.setObjectName("quitButtonAddSymbolBox");
        quitButtonAddSymbolBox.setGeometry(new QRect(290, 190, 82, 28));
        addSymbolPopUpBoxButton = new QPushButton(addSymbolDialogBox);
        addSymbolPopUpBoxButton.setObjectName("addSymbolPopUpBoxButton");
        addSymbolPopUpBoxButton.setGeometry(new QRect(200, 190, 82, 28));
        enterSymbolEditBox = new QLineEdit(addSymbolDialogBox);
        enterSymbolEditBox.setObjectName("enterSymbolEditBox");
        enterSymbolEditBox.setGeometry(new QRect(50, 90, 191, 31));
        enterSymbolEditBox.setMaxLength(1);
        saisirSymboleLabel = new QLabel(addSymbolDialogBox);
        saisirSymboleLabel.setObjectName("saisirSymboleLabel");
        saisirSymboleLabel.setGeometry(new QRect(50, 50, 281, 18));
        if (exemple1.alphabet.isEmpty()) 
        	enterSymbolEditBox.setText("a");
        	
        // errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
       //  errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
        
        // errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
        
        //bouttons text..etc
        addSymbolDialogBox.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "Ajouter un symbole", null));
        quitButtonAddSymbolBox.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "Fermer", null));
        addSymbolPopUpBoxButton.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "+ Ajouter", null));
        saisirSymboleLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "Veuillez saisir un symbole (un caract\u00e8re) :", null));
        errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
        errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
        errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
        errorSymbolAlreadyExist.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "<html><head/><body><p><span style=\" "
        		+ "color:#cf0000;\">Erreur: ce symbole \u00e0 d\u00e9ja \u00e9t\u00e9 saisi</span></p></body></html>", null));
        errorSymbolAlreadyExist.hide();
        
        quitButtonAddSymbolBox.pressed.connect(addSymbolDialogBox, "close()");
        // errorSymbolAlreadyExist.hide();
        addSymbolDialogBox.show();
        addSymbolPopUpBoxButton.clicked.connect(this, "addSymbol()");
        addSymbolDialogBox.connectSlotsByName(); 
        
    }
    
	/***********************************************************************************
	 **********************    FONCTION POUR AJOUTER UN SYMBOLE   **********************
	 ***********************************************************************************/
    
    public void addSymbol()
    {
        if (enterSymbolEditBox.text().isEmpty() ) {
        	warnSymbolNull = new QMessageBox(addSymbolDialogBox);
        	QMessageBox.critical(addSymbolDialogBox, "Error", "Please enter a symbol!");
        	return;
        }
        
    	char symbolEntered;  	
        symbolEntered = new Character(enterSymbolEditBox.text().charAt(0));
        System.out.println("Vous avez saisi" +symbolEntered);
        
        // Vérifier si le symbole saisi existe déja, et afficher un erreur si c'est la cas
		if (exemple1.alphabet.indexOf(symbolEntered) > -1)
		{
			errorSymbolAlreadyExist.show();
	       errorSymbolShown = true;
		}
		else
		{
			if (errorSymbolShown) 
			{ 
				errorSymbolAlreadyExist.hide();
				errorSymbolShown = !errorSymbolShown;
			}
			
			exemple1.ajouterSymbole(symbolEntered);
	       System.out.println(symbolEntered+ "was added");	
		}
        	
        
    }
    
	/***********************************************************************************
	 ********************** DIALOG BOX POUR SUPPRIMER UN SYMBOLE   *********************
	 ***********************************************************************************/
    
    public void delSymbolsBox()
    {
    	if (exemple1.alphabet.isEmpty()) 
    	{
    		warnSymbolEmpty = new QMessageBox(centralwidgetCheckboxes1);
    		QMessageBox.critical(centralwidgetCheckboxes1, "Erreur", "Vous n'avez saisi aucun symbole!");
    		return;
    	}
    	
    	delSymbolDialogBox = new QDialog(centralwidgetCheckboxes1);
    	delSymbolDialogBox.setObjectName("delSymbolDialogBox");
    	delSymbolDialogBox.setEnabled(true);
    	delSymbolDialogBox.resize(new QSize(392, 235).expandedTo(delSymbolDialogBox.minimumSizeHint()));
        quitButtonDelSymbolBox = new QPushButton(delSymbolDialogBox);
        quitButtonDelSymbolBox.setObjectName("quitButtonDelSymbolBox");
        quitButtonDelSymbolBox.setGeometry(new QRect(290, 190, 82, 28));
        delSymbolPopUpBoxButton = new QPushButton(delSymbolDialogBox);
        delSymbolPopUpBoxButton.setObjectName("delSymbolPopUpBoxButton");
        delSymbolPopUpBoxButton.setGeometry(new QRect(180, 190, 102, 28));
        delSymbolComboBox = new QComboBox(delSymbolDialogBox);
        delSymbolComboBox.setObjectName("enterSymbolEditBox");
        delSymbolComboBox.setGeometry(new QRect(50, 90, 191, 31));
        List<String> symbolsStringList = new ArrayList<String>(exemple1.alphabet.size());
        for (char tchar : exemple1.alphabet) 
        { 
        	symbolsStringList.add(String.valueOf(tchar)); 
        }
        delSymbolComboBox.insertItems(1, symbolsStringList);
        delSymbolLabel = new QLabel(delSymbolDialogBox);
        delSymbolLabel.setObjectName("saisirSymboleLabel");
        delSymbolLabel.setGeometry(new QRect(50, 50, 281, 18));
        // errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
       //  errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
        
        // errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
        
        //bouttons text..etc
        delSymbolDialogBox.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "Ajouter un symbole", null));
        quitButtonDelSymbolBox.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "Fermer", null));
        delSymbolPopUpBoxButton.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "+ Ajouter", null));
        delSymbolLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "Saisir un symbole pour le supprimer :", null));
        errorSymbolAlreadyExist = new QLabel(delSymbolDialogBox);
        errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
        errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
        errorSymbolAlreadyExist.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "<html><head/><body><p><span style=\" "
        		+ "color:#cf0000;\">Il n'ya plus de symboles à supprimer</span></p></body></html>", null));
        delSymbolPopUpBoxButton.setText("Supprimer");
        quitButtonDelSymbolBox.setText("Annuler");
        errorSymbolAlreadyExist.hide();
        
        quitButtonDelSymbolBox.pressed.connect(delSymbolDialogBox, "close()");
        // errorSymbolAlreadyExist.hide();
        delSymbolDialogBox.show();
        delSymbolPopUpBoxButton.clicked.connect(this, "delSymbol()");
        delSymbolDialogBox.connectSlotsByName(); 
        
    }
   
	/***********************************************************************************
	 **********************    FONCTION POUR SUPPRIMER UN SYMBOLE  *********************
	 ***********************************************************************************/
    
    public void delSymbol()
    {
    	if (delSymbolComboBox.count() < 1) {
    		errorSymbolAlreadyExist.show();
    		return;
    	}
        
    	exemple1.alphabet.remove(Character.valueOf(delSymbolComboBox.currentText().charAt(0)));
    	delSymbolComboBox.removeItem(delSymbolComboBox.currentIndex());
    	delSymbolDialogBox.close();
    	
        // Vérifier si le symbole saisi existe déja, et afficher un erreur si c'est la cas
        // errorSymbolAlreadyExist
        	   
    }
    
	/***********************************************************************************
	 **********************    FONCTION POUR SUPPRIMER UN SYMBOLE  *********************
	 ***********************************************************************************/
    
    public void displayAlphabetMessageBox()
    {
    	String displayAlphabetText = "";
    	displayAlphabetText = "A = {"+exemple1.affichageAlphabet()+"}";

    	displayAlphabetMsgBox = new QMessageBox(centralwidgetCheckboxes1);
		QMessageBox.information(centralwidgetCheckboxes1, "Voici l'alphabet saisi :", displayAlphabetText);
		
    }
    
    /***********************************************************************************
	 ******************   FONCTION POUR AFFICHER LA TAILLE D'UN ALPHABET ***************
	 ***********************************************************************************/
    
    public void displayAlphabetSizeMessageBox()
    {
    	String displayAlphabetSize = "La taille de votre alphabet est :  ";;

    	displayAlphabetSizeMsgBox = new QMessageBox(centralwidgetCheckboxes1);
		QMessageBox.information(centralwidgetCheckboxes1, "Taille de l'alphabet"
				+ "si :", displayAlphabetSize+exemple1.tailleAlphabet());
		
    }
    
	/***********************************************************************************
	 *************************************** MAIN **************************************
	 ***********************************************************************************/
    
	public static void main(String[] args) 
	{
         exemple1 = new Afn();
         exemple2 = new Afntoafd();

		QApplication.initialize(args); 

		initWindow = new Ui_MainWindow();
		
		QApplication.execStatic(); 
		

	}

}