using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Sms.RNSms
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNSmsModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNSmsModule"/>.
        /// </summary>
        internal RNSmsModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNSms";
            }
        }
    }
}
