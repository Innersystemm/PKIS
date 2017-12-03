using SoapService.EntityClasses;
using SoapService.EnumsAndConstants;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SoapService.Interfaces
{
    [ServiceContract]
    public interface ILogService
    {
        [OperationContract]
        IEnumerable<Log> Get();
    }
}
