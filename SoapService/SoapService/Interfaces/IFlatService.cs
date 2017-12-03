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
    [ServiceContract(Namespace = Constants.BindingNamespaceFlat)]
    public interface IFlatService
    {
        [OperationContract]
        void AddFlat(Flat newflat);

        [OperationContract]
        Flat GetFlat(int id);

        [OperationContract]
        List<Flat> GetAllFlats();

        [OperationContract]
        void UpdateFlat(Flat flats);

        [OperationContract]
        void RemoveFlat(int id);
    }
}
