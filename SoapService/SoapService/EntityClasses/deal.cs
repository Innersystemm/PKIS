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
    [DataContract(IsReference = true, Namespace = Constants.BindingBeans)]
    public class Deal
    {
        [DataMember]
        [Required]
        [Key]
        public int DealID { get; set; }

        [DataMember(Name = "DealDate")]
        [Column(TypeName = "date")]
        [Required]
        public DateTime Date { get; set; }

        [DataMember]
        public double Price { get; set; }

        [DataMember(Name = "DealFlat")]
        public Flat Flat { get; set; }

    }
}