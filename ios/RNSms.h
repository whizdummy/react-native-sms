
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

#import <MessageUI/MessageUI.h>

@interface RNSms : NSObject <RCTBridgeModule>

@end
