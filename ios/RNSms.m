
#import "RNSms.h"

@implementation RNSms

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(sendMessage: (NSArray *) numbers
                  message: (NSString *) message)
{
    MFMessageComposeViewController *msgController = [[MFMessageComposeViewController alloc] init];
    
    if (![MFMessageComposeViewController canSendText]) {
        NSLog(@"SMS message not supported");
    } else {
        msgController.body = message;
        msgController.recipients = numbers;
        
        msgController.messageComposeDelegate = self;
    
        UIViewController *currentViewController = [UIApplication sharedApplication].keyWindow.rootViewController;
        
        while(currentViewController.presentedViewController) {
            currentViewController = currentViewController.presentedViewController;
        }
        
        [currentViewController presentViewController:msgController animated:YES completion:nil];
    }
}

- (void)messageComposeViewController:(nonnull MFMessageComposeViewController *)controller didFinishWithResult:(MessageComposeResult)result {
    switch (result) {
        case MessageComposeResultSent:
            NSLog(@"Message Sent");
            break;
        case MessageComposeResultFailed:
            NSLog(@"Message Failed");
            break;
        case MessageComposeResultCancelled:
            NSLog(@"Message Cancelled");
            break;
    }
    
    [controller dismissViewControllerAnimated:YES completion:nil];
}

@end
