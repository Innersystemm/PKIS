using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SoapService.Enums
{
    public static class Enums
    {
        public enum ObjectStates { ItemAdded, Error, ItemRemoved, ItemUpdated }
        public enum DebugLevel { Debug, Information, Warning, Error, Critical }
    }
}