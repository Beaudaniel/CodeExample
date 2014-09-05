package com.mycompany.app;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import com.smartsheet.api.Smartsheet;
import com.smartsheet.api.SmartsheetBuilder;
import com.smartsheet.api.SmartsheetException;
import com.smartsheet.api.models.AccessLevel;
import com.smartsheet.api.models.Cell;
import com.smartsheet.api.models.Column;
import com.smartsheet.api.models.ColumnType;
import com.smartsheet.api.models.Comment;
import com.smartsheet.api.models.Discussion;
import com.smartsheet.api.models.Folder;
import com.smartsheet.api.models.Home;
import com.smartsheet.api.models.MultiShare;
import com.smartsheet.api.models.ObjectInclusion;
import com.smartsheet.api.models.Row;
import com.smartsheet.api.models.RowWrapper;
import com.smartsheet.api.models.Share;
import com.smartsheet.api.models.Sheet;
import com.smartsheet.api.models.SheetPublish;
import com.smartsheet.api.models.User;
import com.smartsheet.api.models.Workspace;
import com.smartsheet.api.oauth.AuthorizationResult;
import com.smartsheet.api.oauth.OAuthFlow;
import com.smartsheet.api.oauth.OAuthFlowBuilder;
import com.smartsheet.api.oauth.Token;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws SmartsheetException, UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException
    {
        System.out.println( "Hello Worlds!" );
        
     // Set the Access Token
        Token token = new Token();
        token.setAccessToken("my Token");

        // Use the Smartsheet Builder to create a Smartsheet
        Smartsheet smartsheet = new SmartsheetBuilder().setAccessToken(token.getAccessToken()).build();

        // Get home
        Home home = smartsheet.home().getHome(EnumSet.of(ObjectInclusion.TEMPLATES));

        // List home folders
        List<Folder> homeFolders = home.getFolders();
        for(Folder folder : homeFolders){
            System.out.println("folder:"+folder.getName());
        }

        // List Sheets
        List<Sheet> homeSheets = smartsheet.sheets().listSheets();
        for(Sheet sheet : homeSheets){
            System.out.println("sheet:"+sheet.getName());
        }
       
    }
}
