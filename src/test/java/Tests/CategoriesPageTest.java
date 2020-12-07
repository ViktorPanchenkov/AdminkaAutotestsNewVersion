package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoriesPageTest extends TestBase {



    @Before
    public void BeforeAction(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        categoriesPage.GotoGategoriesTab();
    }

    @Test
    public void AddCategory(){
        int Random = (int) (Math.random() *10);
        String Title = "Created by autotest" + Random;
        categoriesPage.ClickOnAddCategoryButton().
                EnterTitle(Title).
                AddCoverImage().
                AddCategoryIcon().
                ClcikOnTheCreateCategoryButton();
        Assert.assertTrue(categoriesPage.IS_Category_Created());
    }
    @Test
    public void EditCategory(){
        int Random = (int) (Math.random() * 10);
        String NewCategoryTitle = "Updated by Aytotest" + Random;
     categoriesPage.ClickOnEditCategoryButton().
             EnterTitle(NewCategoryTitle).
             AddCoverImage().
             AddCategoryIcon().
             ClcikOnUpdateCategoryButton();
     Assert.assertTrue(categoriesPage.IS_CategoryUpdated());
    }
    @Test
    public void DeleteCategory(){
     int numberOfCategory = 1;
     categoriesPage.ClcikOnDeleteCategoryButton(numberOfCategory);
     Assert.assertTrue(categoriesPage.IS_Category_Deleted());

    }
}
