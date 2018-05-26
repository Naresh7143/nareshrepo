package ObjectRepository;

import org.openqa.selenium.By;

public class FacebookHomePage {
	
	//public static final By fb_comment = By.xpath("//div[contains(@class,'UFIAddCommentInput')]");
	
	public static final By fb_comment = By.xpath("//div[@class='_fmk UFICommentAttachmentButtons _5op2 _15i7 _2kwm']/preceding-sibling::div[@role='presentation' and @class='_2xwx _289c']");
    public static final By fb_verify_comment =By.xpath("//span[@class='UFICommentBody']");
    public static final By fb_home =By.xpath("//a[text()='Home']");
    //public static final By fb_comment = By.xpath(".//*[@id='addComment_102477673977508']/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div");
    
}
