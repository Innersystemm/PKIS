using SoapService.EnumsAndConstants;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace SoapService.EntityClasses
{
    [DataContract(IsReference = true, Namespace = Constants.BindingNamespaceFlat + "/bean")]
    public class Flat
    {
        [DataMember]
        [Required]
        [Key]
        public int FlatID { get; set; }

        [DataMember]
        [Required]
        public float Area { get; set; }

        [DataMember]
        [Required]
        public int Rooms { get; set; }

        [DataMember]
        public bool Balcony { get; set; }

        [DataMember(Name = "FlatDeals")]
        public List<Deal> Deals { get; set; }

        [DataMember(Name = "FlatRegion")]
        public Region Region { get; set; }
    }
}