using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;
using System.ComponentModel.DataAnnotations.Schema;
using SoapService.EnumsAndConstants;

namespace SoapService.EntityClasses
{
    [DataContract(IsReference = true, Namespace = Constants.BindingNamespaceDeal + "/bean")]
    public class Deal
    {
        [DataMember]
        [Required]
        [Key]
        public int DealID { get; set; }

        [DataMember(Name = "DealDate")]
        [Required]
        public DateTime Date { get; set; }

        [DataMember]
        public float Price { get; set; }

        [DataMember(Name = "DealFlat")]
        public Flat Flat { get; set; }

    }
}