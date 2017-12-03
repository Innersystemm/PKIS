using SoapService.EntityClasses;
using SoapService.EnumsAndConstants;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace SoapService.Interfaces
{
    [ServiceContract(Namespace = Constants.BindingNamespaceRegion)]
    public interface IRegionService
    {
        [OperationContract]
        void AddRegion(Region region);

        [OperationContract]
        Region GetRegion(int id);

        [OperationContract]
        List<Region> GetAllRegions();

        [OperationContract]
        void UpdateRegion(Region regions);

        [OperationContract]
        void RemoveRegion(int id);
    }
}
